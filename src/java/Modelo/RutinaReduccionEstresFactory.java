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

public class RutinaReduccionEstresFactory implements IRutinaFactory {

    @Override
    public IRutina crearRutina(Usuario usuario) {
        IMaquina yoga = new Maquina("Yoga", 30, 100, 0);
        IMaquina meditacion = new Maquina("Meditación guiada", 30, 100, 0);

        Map<IMaquina, Double> ejercicios = new LinkedHashMap<>();
        ejercicios.put(yoga, null);
        ejercicios.put(meditacion, null);

        List<String> planSemanal = Arrays.asList(
            "Día 1: Yoga 30 minutos",
            "Día 2: Meditación guiada 20 minutos",
            "Día 3: Caminata suave 40 minutos",
            "Día 4: Yoga y respiración",
            "Día 5: Meditación y relajación",
            "Día 6: Caminata y estiramientos",
            "Día 7: Descanso"
        );

        String alimentacion = "Dieta balanceada con alimentos relajantes y antioxidantes.";

        return new Rutina(alimentacion, ejercicios, planSemanal);
    }
}

