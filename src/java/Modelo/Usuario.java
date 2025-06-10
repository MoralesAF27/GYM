/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author andre
 */
package Modelo;

public class Usuario {
    private String nombre;
    private int edad;
    private String sexo;
    private double altura;
    private double peso;
    private String objetivo;

    public Usuario(String nombre, int edad, String sexo, double altura, double peso, String objetivo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
        this.objetivo = objetivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public double calcularIMC() {
        double alturaM = altura / 100.0;
        return peso / (alturaM * alturaM);
    }
}