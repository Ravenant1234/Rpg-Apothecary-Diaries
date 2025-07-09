package org.JuegoApothecaryDiaries;

import java.time.LocalDate;

public class DiagnosticoUtil {

    public static void registrarDiagnostico(Maomao maomao, Enfermedad enfermedad) {
        StringBuilder descripcion = new StringBuilder("Diagnóstico confirmado: " + enfermedad.getNombre() + "\n");
        descripcion.append("Síntomas detectados:\n");
        for (Sintoma s : enfermedad.getSintomas()) {
            descripcion.append(" - ").append(s.getDescripcion()).append("\n");
        }

        EntradaDiario entrada = new EntradaDiario(
                enfermedad.getNombre(),
                descripcion.toString(),
                LocalDate.now(),
                TipoEntrada.ENFERMEDAD
        );

        maomao.getGrimorio().agregarEntrada(entrada);
    }
}
