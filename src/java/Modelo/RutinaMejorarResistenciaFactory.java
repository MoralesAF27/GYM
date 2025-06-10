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

public class RutinaMejorarResistenciaFactory implements IRutinaFactory {

    @Override
    public IRutina crearRutina(Usuario usuario) {
        IMaquina correr = new Maquina("Correr en cinta", 40, 120, 0);
        IMaquina bicicleta = new Maquina("Bicicleta estática", 40, 120, 0);

        Map<IMaquina, Double> ejercicios = new LinkedHashMap<>();
        ejercicios.put(correr, null);
        ejercicios.put(bicicleta, null);

        List<String> planSemanal = Arrays.asList(
            "Día 1: Correr 5 km",
            "Día 2: Natación 30 minutos",
            "Día 3: Bicicleta 40 minutos",
            "Día 4: Correr 7 km",
            "Día 5: Entrenamiento cruzado",
            "Día 6: Yoga y estiramientos",
            "Día 7: Descanso"
        );

        String alimentacion = "Dieta equilibrada rica en carbohidratos complejos y proteínas.";

        return new Rutina(alimentacion, ejercicios, planSemanal);
    }
}

