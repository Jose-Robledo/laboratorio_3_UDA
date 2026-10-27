package com.udea.funcional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Contiene la lógica solicitada en los tres ejercicios del taller.
 */
public final class FuncionesTaller {

    private FuncionesTaller() {
        // Esta clase solo ofrece métodos estáticos.
    }

    /**
     * Selecciona ciudades que empiezan por La letra seleccionada, las convierte a mayúsculas
     * y las ordena alfabéticamente.
     *
     * @param ciudades lista de ciudades que se va a procesar
     * @return nueva lista con las ciudades filtradas
     */
    public static List<String> filtrarCiudadesPorLetra(List<String> ciudades, char letra) {
        return ciudades.stream()
                .filter(ciudad -> ciudad.toUpperCase().startsWith(String.valueOf(letra).toUpperCase()))
                .toList();
    }

    /**
     * Conserva las notas aprobadas, les suma 0.2 y limita el resultado a 5.0.
     *
     * @param notas lista original de notas
     * @return lista con las notas aprobadas y mejoradas
     */
    public static List<Double> notasMejoradas(List<Double> notas) {
        return notas.stream()
                .filter(nota -> nota >= 3.0)
                .map(nota -> Math.min(nota + 0.2, 5.0))
                .collect(Collectors.toList());
    }

    /**
     * Calcula una potencia entera usando recursividad, sin Math.pow().
     * El exponente debe ser mayor o igual que cero.
     *
     * @param base número que se eleva
     * @param exponente cantidad de multiplicaciones
     * @return base elevado al exponente
     * @throws IllegalArgumentException si el exponente es negativo
     */
    public static int potencia(int base, int exponente) {
        if (exponente < 0) {
            throw new IllegalArgumentException(
                    "El exponente debe ser mayor o igual que cero."
            );
        }

        // Caso base: cualquier número elevado a cero es 1.
        if (exponente == 0) {
            return 1;
        }

        // Caso recursivo: base^n = base * base^(n-1).
        return base * potencia(base, exponente - 1);
    }
}
