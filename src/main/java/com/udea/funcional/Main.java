package com.udea.funcional;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Punto de entrada del Taller 3 de Paradigma Funcional.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n==========================================");
            System.out.println("   TALLER 3 - PARADIGMA FUNCIONAL (JAVA)  ");
            System.out.println("==========================================");
            System.out.println("1. Ejercicio 1: Filtrar lista de ciudades por letra");
            System.out.println("2. Ejercicio 2: Procesar notas (aprobar e incrementar)");
            System.out.println("3. Ejercicio 3: Calcular potencia (recursiva)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor ingrese un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> ejercicioCiudades();
                case 2 -> ejercicioNotas();
                case 3 -> ejercicioPotencia();
                case 0 -> System.out.println("¡Saliendo del programa!");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static void ejercicioCiudades() {
        List<String> ciudades = List.of(
                "Medellin", "Bogota", "Cali", "Pereira", "Monteria", 
                "Marinilla", "Malpelo", "Barranquilla", "Bucaramanga", 
                "Cartagena", "Manizales", "Mocoa", "Mitú", "Cúcuta", 
                "Santa Marta", "Pasto", "Popayán", "Armenia", 
                "Ibague", "Villavicencio", "Valledupar", "Riohacha", 
                "Tunja", "Sincelejo", "Florencia", "Yopal", "Quibdó"
        );

        System.out.println("\n--- EJERCICIO 1: FILTRAR CIUDADES ---");
        System.out.println("Lista completa de ciudades:");
        ciudades.forEach(c -> System.out.println("  - " + c));

        System.out.print("\nIngrese la letra por la que desea filtrar: ");
        String entrada = scanner.nextLine().trim();

        if (entrada.isEmpty()) {
            System.out.println("No ingresó ninguna letra.");
            return;
        }

        char letra = entrada.charAt(0);

        // Llamada directa a tu función del taller
        List<String> filtradas = FuncionesTaller.filtrarCiudadesPorLetra(ciudades, letra);

        System.out.println("\nResultados para la letra '" + letra + "':");
        if (filtradas.isEmpty()) {
            System.out.println("No se encontraron ciudades que comiencen con esa letra.");
        } else {
            filtradas.forEach(c -> System.out.println("  -> " + c));
        }
    }

    private static void ejercicioNotas() {
        System.out.println("\n--- EJERCICIO 2: NOTAS APROBADAS CON INCREMENTO ---");
        System.out.print("¿Cuántas notas desea ingresar? ");
        int cantidad = leerEnteroPositivo();

        List<Double> notas = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.printf("Ingrese la nota #%d (ej. 3.5): ", i + 1);
            while (!scanner.hasNextDouble()) {
                System.out.print("Entrada no válida. Ingrese un número decimal: ");
                scanner.next();
            }
            notas.add(scanner.nextDouble());
        }

        System.out.println("\nNotas aprobadas y mejoradas:");
        // Llamada directa a tu función del taller
        FuncionesTaller.notasMejoradas(notas)
                .forEach(nota -> System.out.printf("  -> %.1f%n", nota));
    }

    private static void ejercicioPotencia() {
        System.out.println("\n--- EJERCICIO 3: POTENCIA RECURSIVA ---");

        System.out.print("Ingrese la base (entero): ");
        int base = leerEntero();

        System.out.print("Ingrese el exponente (entero >= 0): ");
        int exponente = leerEnteroPositivo();

        try {
            // Llamada directa a tu función del taller
            int resultado = FuncionesTaller.potencia(base, exponente);
            System.out.printf("%nResultado: %d elevado a %d = %d%n", base, exponente, resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Métodos auxiliares para la lectura segura por consola
    private static int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número entero válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static int leerEnteroPositivo() {
        int num;
        do {
            num = leerEntero();
            if (num < 0) {
                System.out.print("El número debe ser mayor o igual a 0: ");
            }
        } while (num < 0);
        return num;
    }
}