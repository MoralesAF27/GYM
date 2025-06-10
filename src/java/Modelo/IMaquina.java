/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author andre
 */
package Modelo;

public interface IMaquina {
    String getNombre();
    /**
     * Calcula el peso recomendado para el usuario según su peso corporal.
     * Retorna null si la máquina no usa peso.
     */
    Double calcularPesoUsuario(double pesoUsuario);
}
