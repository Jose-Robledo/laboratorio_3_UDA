package com.udea.funcional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class FuncionesTallerTest {

    @Test
    void filtraCiudadesPorLetraSeleccionada() {
        List<String> resultado = FuncionesTaller.filtrarCiudadesPorLetra(
                List.of("Medellin", "Bogota", "Monteria", "Cali"), 'M'
        );

        assertEquals(List.of("MEDELLIN", "MONTERIA"), resultado);
    }

    @Test
    void filtraCiudadesSoportandoMinusculasYMayusculas() {
        List<String> resultado = FuncionesTaller.filtrarCiudadesPorLetra(
                List.of("Medellin", "Bogota", "monteria", "Cali"), 'm'
        );

        assertEquals(List.of("MEDELLIN", "MONTERIA"), resultado);
    }

    @Test
    void devuelveListaVaciaSiNingunaCiudadCoincideConLaLetra() {
        assertTrue(FuncionesTaller.filtrarCiudadesPorLetra(
                List.of("Bogota", "Cali", "Pereira"), 'M'
        ).isEmpty());
    }

    @Test
    void filtraNotasAprobadasYLasIncrementa() {
        List<Double> resultado = FuncionesTaller.notasMejoradas(
                List.of(2.5, 4.0, 3.5, 1.8, 4.8, 3.0, 2.9)
        );

        assertEquals(List.of(4.2, 3.7, 5.0, 3.2), resultado);
    }

    @Test
    void limitaNotaMaximaA5() {
        assertEquals(List.of(5.0),
                FuncionesTaller.notasMejoradas(List.of(5.0)));
    }

    @Test
    void permiteUnaNotaExactamenteIgualA3() {
        assertEquals(List.of(3.2),
                FuncionesTaller.notasMejoradas(List.of(3.0)));
    }

    @Test
    void potenciaCalculaEjemploDelTaller() {
        assertEquals(32, FuncionesTaller.potencia(2, 5));
    }

    @Test
    void potenciaConExponenteCeroDevuelveUno() {
        assertEquals(1, FuncionesTaller.potencia(9, 0));
    }

    @Test
    void potenciaAceptaBaseCeroConExponentePositivo() {
        assertEquals(0, FuncionesTaller.potencia(0, 3));
    }

    @Test
    void potenciaRechazaExponenteNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> FuncionesTaller.potencia(2, -1));
    }
}