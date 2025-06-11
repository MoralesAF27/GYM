package Control;

import Modelo.IMaquina;
import Modelo.Maquina;
import Modelo.Rutina;
import java.sql.*;
import java.util.*;

public class RutinaDAO {

    public Rutina obtenerRutinaPorNombre(String nombreRutina) throws SQLException {
        String sqlRutina = "SELECT id, nombre, alimentacion, plan_semanal FROM rutinas WHERE nombre = ?";
        String sqlMaquinas = "SELECT m.id, m.nombre, m.peso_minimo, m.peso_maximo, m.peso_base "
                           + "FROM maquinas m "
                           + "JOIN rutina_maquinas rm ON m.id = rm.maquina_id "
                           + "WHERE rm.rutina_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psRutina = conn.prepareStatement(sqlRutina);
             PreparedStatement psMaquinas = conn.prepareStatement(sqlMaquinas)) {

            // Obtener datos básicos de la rutina
            psRutina.setString(1, nombreRutina);
            ResultSet rsRutina = psRutina.executeQuery();

            if (!rsRutina.next()) {
                return null;
            }

            int rutinaId = rsRutina.getInt("id");
            String nombre = rsRutina.getString("nombre");
            String alimentacion = rsRutina.getString("alimentacion");
            String planSemanal = rsRutina.getString("plan_semanal");

            // Obtener máquinas asociadas
            psMaquinas.setInt(1, rutinaId);
            ResultSet rsMaquinas = psMaquinas.executeQuery();

            Map<IMaquina, Double> ejercicios = new LinkedHashMap<>();
            while (rsMaquinas.next()) {
                Maquina maquina = new Maquina(
                    rsMaquinas.getString("nombre"),
                    rsMaquinas.getDouble("peso_minimo"),
                    rsMaquinas.getDouble("peso_maximo"),
                    rsMaquinas.getDouble("peso_base")
                );
                ejercicios.put(maquina, null);
            }

            // Crear y retornar rutina completa
            Rutina rutina = new Rutina(alimentacion, ejercicios, Arrays.asList(planSemanal.split(";")));
            rutina.setNombre(nombre);
            return rutina;
        }
    }
}