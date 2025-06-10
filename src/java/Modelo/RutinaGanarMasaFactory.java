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

public class RutinaGanarMasaFactory implements IRutinaFactory {

    @Override
    public IRutina crearRutina(Usuario usuario) {
        double pesoUsuario = usuario.getPeso();

        IMaquina prensaPiernas = new Maquina("Prensa de Piernas", 50, 120, 50);
        IMaquina maquinaPecho = new Maquina("Máquina de Pecho", 50, 120, 40);
        IMaquina remo = new Maquina("Remo sentado", 50, 120, 35);

        Map<IMaquina, Double> ejercicios = new LinkedHashMap<>();
        ejercicios.put(prensaPiernas, prensaPiernas.calcularPesoUsuario(pesoUsuario));
        ejercicios.put(maquinaPecho, maquinaPecho.calcularPesoUsuario(pesoUsuario));
        ejercicios.put(remo, remo.calcularPesoUsuario(pesoUsuario));

        List<String> planSemanal = Arrays.asList(
            "Día 1: Pecho y tríceps con pesos altos",
            "Día 2: Espalda y bíceps",
            "Día 3: Piernas y abdominales",
            "Día 4: Hombros y trapecio",
            "Día 5: Full body ligero",
            "Día 6: Descanso activo",
            "Día 7: Descanso total"
        );

        String alimentacion = "Dieta hipercalórica rica en proteínas y carbohidratos complejos.";

        return new Rutina(alimentacion, ejercicios, planSemanal);
    }
}

