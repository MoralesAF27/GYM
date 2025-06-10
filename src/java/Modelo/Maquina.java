/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author andre
 */
package Modelo;

public class Maquina implements IMaquina {
    private String nombre;
    private double pesoMinimo;
    private double pesoMaximo;
    private double pesoBase;

    public Maquina(String nombre, double pesoMinimo, double pesoMaximo, double pesoBase) {
        this.nombre = nombre;
        this.pesoMinimo = pesoMinimo;
        this.pesoMaximo = pesoMaximo;
        this.pesoBase = pesoBase;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Double calcularPesoUsuario(double pesoUsuario) {
        if (pesoBase == 0) {
            return null; // No aplica peso
        }
        double pesoCalculado;
        if (pesoUsuario < pesoMinimo) {
            pesoCalculado = pesoBase * 0.8;
        } else if (pesoUsuario > pesoMaximo) {
            pesoCalculado = pesoBase * 1.2;
        } else {
            double factor = (pesoUsuario - pesoMinimo) / (pesoMaximo - pesoMinimo);
            pesoCalculado = pesoBase * (0.8 + 0.4 * factor);
        }
        // Redondear al múltiplo de 5 más cercano
        return (double) (Math.round(pesoCalculado / 5.0) * 5);
    }
}
