package org.JuegoApothecaryDiaries;

import java.util.Arrays;

public class DiagnosticoTest {
    public static void main(String[] args) {
        Maomao mao = new Maomao();

        Enfermedad envenenamiento = new Enfermedad(
                "Intoxicación por mercurio",
                7,
                Arrays.asList(
                        new Sintoma("Temblores"),
                        new Sintoma("Lengua azulada"),
                        new Sintoma("Fatiga extrema")
                )
        );

        System.out.println(" Síntomas observados:");
        for (Sintoma s : envenenamiento.getSintomas()) {
            System.out.println("- " + s);
        }

        Diagnostico.intentarDiagnosticar(mao, envenenamiento);
    }
}
