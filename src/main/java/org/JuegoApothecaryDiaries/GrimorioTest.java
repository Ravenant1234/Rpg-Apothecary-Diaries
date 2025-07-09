package org.JuegoApothecaryDiaries;

import java.time.LocalDate;

public class GrimorioTest {
    public static void main(String[] args) {
        Grimorio grimorio = new Grimorio();

        EntradaDiario e1 = new EntradaDiario(
                "Fiebre del Loto",
                "Síntomas observados: sudor frío, pulso débil, somnolencia.",
                LocalDate.now(),
                TipoEntrada.ENFERMEDAD
        );

        EntradaDiario e2 = new EntradaDiario(
                "Hierba de Sauce",
                "Planta utilizada para aliviar fiebre leve.",
                LocalDate.now(),
                TipoEntrada.PLANTA
        );

        grimorio.agregarEntrada(e1);
        grimorio.agregarEntrada(e2);

        grimorio.imprimirTodo();
    }
}
