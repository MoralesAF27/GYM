/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author andre
 */
package Modelo;

import java.util.List;
import java.util.Map;

public interface IRutina {
    String getAlimentacion();
    Map<IMaquina, Double> getEjerciciosConPeso();
    List<String> getPlanSemanal();
}

