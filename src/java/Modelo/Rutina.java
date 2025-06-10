/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author andre
 */
package Modelo;

import java.util.List;
import java.util.Map;

public class Rutina implements IRutina {
    private String alimentacion;
    private Map<IMaquina, Double> ejerciciosConPeso;
    private List<String> planSemanal;

    public Rutina(String alimentacion, Map<IMaquina, Double> ejerciciosConPeso, List<String> planSemanal) {
        this.alimentacion = alimentacion;
        this.ejerciciosConPeso = ejerciciosConPeso;
        this.planSemanal = planSemanal;
    }

    @Override
    public String getAlimentacion() {
        return alimentacion;
    }

    @Override
    public Map<IMaquina, Double> getEjerciciosConPeso() {
        return ejerciciosConPeso;
    }

    @Override
    public List<String> getPlanSemanal() {
        return planSemanal;
    }
}
