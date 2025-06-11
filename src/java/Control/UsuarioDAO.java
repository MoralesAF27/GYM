package Control;

import Modelo.Usuario;

import java.sql.*;
import java.time.LocalDate;

public class UsuarioDAO {

    public int insertarUsuario(Usuario usuario, String correo, String contraseña) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, edad, sexo, altura, peso, objetivo, correo, contraseña, fecha_registro) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, usuario.getNombre());
            ps.setInt(2, usuario.getEdad());
            ps.setString(3, usuario.getSexo());
            ps.setDouble(4, usuario.getAltura());
            ps.setDouble(5, usuario.getPeso());
            ps.setString(6, usuario.getObjetivo());
            ps.setString(7, correo);
            ps.setString(8, contraseña);
            ps.setDate(9, java.sql.Date.valueOf(LocalDate.now()));

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // Retorna el ID generado
                } else {
                    throw new SQLException("No se pudo obtener el ID del usuario insertado.");
                }
            }
        }
    }

    public void asignarRutinaUsuario(int usuarioId, int rutinaId) throws SQLException {
        String sql = "INSERT INTO usuario_rutinas (usuario_id, rutina_id, fecha_asignacion) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, usuarioId);
            ps.setInt(2, rutinaId);
            ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));

            ps.executeUpdate();
        }
    }

    public Usuario obtenerUsuarioPorCorreo(String correoUsuario) throws SQLException {
        String sql = "SELECT nombre, edad, sexo, altura, peso, objetivo FROM usuarios WHERE correo = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, correoUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    int edad = rs.getInt("edad");
                    String sexo = rs.getString("sexo");
                    double altura = rs.getDouble("altura");
                    double peso = rs.getDouble("peso");
                    String objetivo = rs.getString("objetivo");

                    return new Usuario(nombre, edad, sexo, altura, peso, objetivo);
                } else {
                    return null; // Usuario no encontrado
                }
            }
        }
    }
}
