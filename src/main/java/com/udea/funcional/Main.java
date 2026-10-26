package com.udea.funcional;

import java.util.List;

/**
 * Punto de entrada del Taller 3 de Paradigma Funcional.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" TALLER 3 - PARADIGMA FUNCIONAL (JAVA)");
        System.out.println("==========================================");

        ejercicioCiudades();
        ejercicioNotas();
        ejercicioPotencia();
    }

    private static void ejercicioCiudades() {
        List<String> ciudades = List.of(
                "Medellin", "Bogota", "Cali", "Pereira",
                "Monteria", "Marinilla", "Malpelo", "Barranquilla"
        );

        System.out.println("\nEJERCICIO 1: Ciudades que comienzan por M");
        FuncionesTaller.filtrarCiudadesM(ciudades)
                .forEach(System.out::println);
    }

    private static void ejercicioNotas() {
        List<Double> notas = List.of(2.5, 4.0, 3.5, 1.8, 4.8, 3.0, 2.9);

        System.out.println("\nEJERCICIO 2: Notas aprobadas con incremento");
        FuncionesTaller.notasMejoradas(notas)
                .forEach(nota -> System.out.printf("%.1f%n", nota));
    }

    private static void ejercicioPotencia() {
        int base = 2;
        int exponente = 5;

        System.out.println("\nEJERCICIO 3: Potencia mediante recursividad");
        System.out.printf("%d elevado a %d = %d%n",
                base, exponente, FuncionesTaller.potencia(base, exponente));
    }
}
