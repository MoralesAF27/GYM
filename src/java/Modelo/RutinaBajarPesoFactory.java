/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author andre
 */
package Modelo;

import java.util.*;

public class RutinaBajarPesoFactory implements IRutinaFactory {

    @Override
    public IRutina crearRutina(Usuario usuario) {
        double pesoUsuario = usuario.getPeso();

        IMaquina cardio = new Maquina("Cardio en cinta", 40, 120, 0);
        IMaquina circuitoFuerza = new Maquina("Circuito de fuerza", 40, 120, 20);

        Map<IMaquina, Double> ejercicios = new LinkedHashMap<>();
        ejercicios.put(cardio, cardio.calcularPesoUsuario(pesoUsuario));
        ejercicios.put(circuitoFuerza, circuitoFuerza.calcularPesoUsuario(pesoUsuario));

        List<String> planSemanal = Arrays.asList(
            "Día 1: Cardio intenso + circuito de fuerza",
            "Día 2: HIIT y estiramientos",
            "Día 3: Descanso activo (caminata ligera)",
            "Día 4: Cardio prolongado",
            "Día 5: Circuito de fuerza + abdominales",
            "Día 6: Yoga y movilidad",
            "Día 7: Descanso"
        );

        String alimentacion = "Dieta hipocalórica, alta en proteínas y baja en grasas.";

        return new Rutina(alimentacion, ejercicios, planSemanal);
    }
}

