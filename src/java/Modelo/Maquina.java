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

    public double calcularPesoUsuario(double pesoUsuario) {
        // Lógica para calcular el peso basado en el peso del usuario
        double pesoCalculado = pesoBase * (pesoUsuario / 70.0); // 70kg como referencia
        return Math.max(pesoMinimo, Math.min(pesoCalculado, pesoMaximo));
    }

    // Getters adicionales
    public double getPesoMinimo() {
        return pesoMinimo;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public double getPesoBase() {
        return pesoBase;
    }
}