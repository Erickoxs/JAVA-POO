package Vehiculo;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto Vehiculo con valores iniciales
        Vehiculo miAuto = new Vehiculo("Toyota", "Corolla", 2020, 50000);

        // Mostrar la información inicial
        miAuto.mostrarInfo();

        // Conducir 150 km
        miAuto.conducir(150);

        // Mostrar la información después de conducir
        System.out.println("\nDespués de conducir:");
        miAuto.mostrarInfo();
    }
}