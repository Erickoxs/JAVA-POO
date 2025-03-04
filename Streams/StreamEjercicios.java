package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamEjercicios {
    public static void main(String[] args) {
        List<String> calificaciones = Arrays.asList(
            "Juan,Matemáticas,85",
            "Ana,Historia,90",
            "Pedro,Matemáticas,70",
            "Juan,Historia,75",
            "Ana,Matemáticas,95",
            "Pedro,Historia,80"
        );

        int calificacionParaAprobar = 75;

        double promedio = calcularPromedio(calificaciones);
        System.out.println("\n\nPromedio de calificaciones: " + promedio);

        Map<String, Integer> estudiantesPorMateria = contarEstudiantes(calificaciones);
        System.out.println("Cantidad de estudiantes por materia: " + estudiantesPorMateria);

        Map<String, Double> resultado = materiaPromedioMasAlto(calificaciones);
        System.out.println("Materia(s) con el promedio más alto: " + resultado);

        List<String> aprobados = filtrarNotasPorUnValor(calificaciones, calificacionParaAprobar);
        System.out.println("Notas mayores a " + calificacionParaAprobar + ": " + aprobados);
    }

    /**
     * Calcula el promedio general de todas las calificaciones.
     */
    public static double calcularPromedio(List<String> calificaciones) {
        return calificaciones.stream()
                .mapToDouble(calificacion -> Double.parseDouble(calificacion.split(",")[2]))
                .average()
                .orElse(0.0); // Retorna 0.0 si no hay calificaciones
    }

    /**
     * Cuenta cuántos estudiantes tomaron cada materia.
     */
    public static Map<String, Integer> contarEstudiantes(List<String> calificaciones) {
        return calificaciones.stream()
                .map(registro -> registro.split(",")[1]) // Extrae la materia
                .collect(Collectors.toMap(
                        materia -> materia,
                        materia -> 1,
                        Integer::sum // Suma 1 por cada ocurrencia de la materia
                ));
    }

    /**
     * Filtra las calificaciones que sean mayores a un valor dado.
     */
    public static List<String> filtrarNotasPorUnValor(List<String> calificaciones, int calificacionParaAprobar) {
        return calificaciones.stream()
                .filter(calificacion -> Integer.parseInt(calificacion.split(",")[2]) > calificacionParaAprobar)
                .collect(Collectors.toList());
    }

    /**
     * Encuentra la materia con el promedio más alto.
     */
    public static Map<String, Double> materiaPromedioMasAlto(List<String> calificaciones) {
        // Agrupa notas por materia
        Map<String, List<Integer>> materiaNotas = new HashMap<>();

        for (String registro : calificaciones) {
            String[] datos = registro.split(",");
            String materia = datos[1];
            int nota = Integer.parseInt(datos[2]);

            materiaNotas.putIfAbsent(materia, new ArrayList<>());
            materiaNotas.get(materia).add(nota);
        }

        // Calcula el promedio de cada materia
        Map<String, Double> promedios = materiaNotas.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0.0)
                ));

        // Encuentra el máximo promedio
        double maxPromedio = promedios.values().stream().max(Double::compare).orElse(0.0);

        // Filtra las materias con el promedio máximo
        return promedios.entrySet().stream()
                .filter(entry -> entry.getValue() == maxPromedio)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
