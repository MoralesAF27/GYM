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

public class RutinaCondicionGeneralFactory implements IRutinaFactory {

    @Override
    public IRutina crearRutina(Usuario usuario) {
        double pesoUsuario = usuario.getPeso();

        IMaquina fuerza = new Maquina("Entrenamiento de fuerza", 40, 120, 30);
        IMaquina cardio = new Maquina("Cardio ligero", 40, 120, 0);

        Map<IMaquina, Double> ejercicios = new LinkedHashMap<>();
        ejercicios.put(fuerza, fuerza.calcularPesoUsuario(pesoUsuario));
        ejercicios.put(cardio, null);

        List<String> planSemanal = Arrays.asList(
            "Día 1: Entrenamiento de fuerza moderado",
            "Día 2: Cardio ligero",
            "Día 3: Entrenamiento funcional",
            "Día 4: Descanso activo",
            "Día 5: Circuito de fuerza y cardio",
            "Día 6: Estiramientos y movilidad",
            "Día 7: Descanso"
        );

        String alimentacion = "Dieta equilibrada y variada.";

        return new Rutina(alimentacion, ejercicios, planSemanal);
    }
}

