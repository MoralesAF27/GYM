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

public class RutinaRehabilitacionFactory implements IRutinaFactory {

    @Override
    public IRutina crearRutina(Usuario usuario) {
        IMaquina movilidad = new Maquina("Ejercicios de movilidad", 30, 100, 0);
        IMaquina estiramientos = new Maquina("Estiramientos suaves", 30, 100, 0);

        Map<IMaquina, Double> ejercicios = new LinkedHashMap<>();
        ejercicios.put(movilidad, null);
        ejercicios.put(estiramientos, null);

        List<String> planSemanal = Arrays.asList(
            "Día 1: Movilidad articular y estiramientos suaves",
            "Día 2: Ejercicios de fortalecimiento leve",
            "Día 3: Estiramientos y respiración",
            "Día 4: Movilidad y fortalecimiento",
            "Día 5: Estiramientos y relajación",
            "Día 6: Caminata suave",
            "Día 7: Descanso"
        );

        String alimentacion = "Dieta antiinflamatoria y balanceada.";

        return new Rutina(alimentacion, ejercicios, planSemanal);
    }
}

