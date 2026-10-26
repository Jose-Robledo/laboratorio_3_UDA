package com.udea.funcional;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FuncionesTallerTest {

    @Test
    void filtraCiudadesQueEmpiezanPorM() {
        List<String> resultado = FuncionesTaller.filtrarCiudadesM(
                List.of("Medellin", "Bogota", "Monteria", "Cali")
        );

        assertEquals(List.of("MEDELLIN", "MONTERIA"), resultado);
    }

    @Test
    void ordenaCiudadesAlfabeticamente() {
        List<String> resultado = FuncionesTaller.filtrarCiudadesM(
                List.of("Monteria", "Malpelo", "Marinilla")
        );

        assertEquals(List.of("MALPELO", "MARINILLA", "MONTERIA"), resultado);
    }

    @Test
    void devuelveListaVaciaSiNingunaCiudadEmpiezaPorM() {
        assertTrue(FuncionesTaller.filtrarCiudadesM(
                List.of("Bogota", "Cali", "Pereira")
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
