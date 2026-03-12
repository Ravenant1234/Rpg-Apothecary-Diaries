package org.JuegoApothecaryDiaries.Tests;

import java.util.Arrays;
import java.util.List;

import org.JuegoApothecaryDiaries.Personajes.Maomao;

public class DiagnosticoTest {
    public static void main(String[] args) {
        Maomao mao = new Maomao();

        List<Sintoma> sintomas = Arrays.asList(
                new Sintoma("Temblores"),
                new Sintoma("Lengua azulada"),
                new Sintoma("Fatiga extrema")
        );

        Enfermedad envenenamiento = new Enfermedad(
                "Intoxicación por mercurio",
                7,
                sintomas
        );

        System.out.println(" Síntomas observados:");
        for (Sintoma s : envenenamiento.getSintomas()) {
            System.out.println("- " + s);
        }

        List<String> sintomasDetectados = mao.detectarSintomas(envenenamiento);
        System.out.println("Síntomas que Maomao puede ver:");
        sintomasDetectados.forEach(System.out::println);




    }
}
