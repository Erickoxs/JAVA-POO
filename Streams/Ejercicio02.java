package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class Ejercicio02 {
    public static void main(String[] args) {
        List<String> facturas = Arrays.asList(
            "F001,ClienteA,1000.00,19",
            "F002,ClienteB,1500.00,19",
            "F003,ClienteA,2000.00,19",
            "F004,ClienteC,2500.00,19",
            "F005,ClienteB,3000.00,19"
        );

        // Calcular monto total con IVA
        double montoTotalIva = calcularMontoTotalIva(facturas);
        System.out.println("Monto total con IVA: " + montoTotalIva);

        // Obtener ingresos por cliente
        Map<String, Integer> ingresos = ingresosPorCliente(facturas);
        System.out.println("Ingresos por cliente: " + ingresos);

        // Filtrar facturas por valor
        double valorFactura = 2300.00;
        List<String> facturasFiltradas = filtraFacturasPorValor(facturas, valorFactura);
        System.out.println("Facturas mayores a " + valorFactura + ": " + facturasFiltradas);

        // Cliente con mayor ingreso
        Map<String, Integer> mayorIngreso = mayoringresosPorCliente(facturas);
        System.out.println("Cliente con mayor ingreso: " + mayorIngreso);
    }

    public static double calcularMontoTotalIva(List<String> facturas) {
        return facturas.stream()
                .mapToDouble(f -> {
                    String[] datos = f.split(",");
                    double precio = Double.parseDouble(datos[2]);
                    double iva = Double.parseDouble(datos[3]) / 100;
                    return precio * (1 + iva);
                })
                .sum();
    }

    public static Map<String, Integer> ingresosPorCliente(List<String> facturas) {
        return facturas.stream()
                .map(f -> f.split(","))
                .collect(Collectors.groupingBy(
                        datos -> datos[1],
                        Collectors.summingInt(datos -> (int) Double.parseDouble(datos[2]))
                ));
    }

    public static List<String> filtraFacturasPorValor(List<String> facturas, double valorFactura) {
        return facturas.stream()
                .filter(factura -> Double.parseDouble(factura.split(",")[2]) > valorFactura)
                .collect(Collectors.toList());
    }

    public static Map<String, Integer> mayoringresosPorCliente(List<String> facturas) {
        Map<String, Integer> ingresosPorCliente = facturas.stream()
                .map(f -> f.split(","))
                .collect(Collectors.groupingBy(
                        datos -> datos[1],
                        Collectors.summingInt(datos -> (int) Double.parseDouble(datos[2]))
                ));
    
       
        return ingresosPorCliente.entrySet().stream()
                .max(Map.Entry.comparingByValue()) 
                .map(entry -> Map.of(entry.getKey(), entry.getValue())) 
                .orElse(Collections.emptyMap()); 
    }
    
}
