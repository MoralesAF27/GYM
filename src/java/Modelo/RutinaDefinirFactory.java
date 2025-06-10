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

public class RutinaDefinirFactory implements IRutinaFactory {

    @Override
    public IRutina crearRutina(Usuario usuario) {
        double pesoUsuario = usuario.getPeso();

        IMaquina pesasSuperior = new Maquina("Pesas tren superior", 50, 120, 25);
        IMaquina hiit = new Maquina("Entrenamiento HIIT", 40, 120, 0);

        Map<IMaquina, Double> ejercicios = new LinkedHashMap<>();
        ejercicios.put(pesasSuperior, pesasSuperior.calcularPesoUsuario(pesoUsuario));
        ejercicios.put(hiit, hiit.calcularPesoUsuario(pesoUsuario));

        List<String> planSemanal = Arrays.asList(
            "Día 1: Pesas tren superior",
            "Día 2: HIIT 20 minutos",
            "Día 3: Pesas tren inferior",
            "Día 4: HIIT 25 minutos",
            "Día 5: Pesas cuerpo completo",
            "Día 6: Cardio suave y estiramientos",
            "Día 7: Descanso"
        );

        String alimentacion = "Dieta balanceada con déficit calórico y alta en proteínas.";

        return new Rutina(alimentacion, ejercicios, planSemanal);
    }
}

