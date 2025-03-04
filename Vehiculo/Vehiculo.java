package Vehiculo;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int año;  // Cambié "fecha" por "año"
    private double km;

    // Constructor con parámetros
    public Vehiculo(String marca, String modelo, int año, double km) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.km = km;
    }

    // Constructor vacío
    public Vehiculo() {}

    // Getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() { // Cambié "getFecha()" por "getAño()"
        return año;
    }

    public double getKm() {
        return km;
    }

    // Setters
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAño(int año) { // Cambié "setFecha()" por "setAño()"
        this.año = año;
    }

    public void setKm(double km) {
        this.km = km;
    }

    // Método para mostrar la información del vehículo
    public void mostrarInfo() {
        System.out.println("\nMarca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + año);
        System.out.println("Kilometraje: " + km + " km");
    }

    // Método para conducir el vehículo y aumentar el kilometraje
    public void conducir(double km) {
        this.km += km; // Ahora suma la cantidad correcta de kilómetros
        System.out.println("\nHas conducido " + km + " km.");
    }
}
