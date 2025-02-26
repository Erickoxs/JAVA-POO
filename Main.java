// Clase Main
public class Main {
    public static void main(String[] args) {
        // Crear un producto usando el constructor vacío
        Producto producto1 = new Producto();

        // Asignar valores con setters
        producto1.setNombre("Teclado");
        producto1.setPrecio(20000);
        producto1.setCantidad(6);

        // Mostrar la información
        producto1.mostrarInfo();
    }
}