package org.JuegoApothecaryDiaries;

import java.util.List;

public class Diagnostico {
    private Enfermedad enfermedadSospechada;
    private List<String> sintomasObservados;
    private boolean correcto;

    public Diagnostico(Enfermedad enfermedadSospechada, List<String> sintomasObservados) {
        this.enfermedadSospechada = enfermedadSospechada;
        this.sintomasObservados = sintomasObservados;
        this.correcto = evaluar();
    }

    private boolean evaluar() {
        List<Sintoma> sintomasEnfermedad = enfermedadSospechada.getSintomas();
        int coincidencias = 0;

        for (String observado : sintomasObservados) {
            for (Sintoma real : sintomasEnfermedad) {
                if (real.getDescripcion().equalsIgnoreCase(observado)) {
                    coincidencias++;
                }
            }
        }

        // Ejemplo: se requiere al menos la mitad de los síntomas para considerarlo correcto
        return coincidencias >= (sintomasEnfermedad.size() / 2);
    }

    public boolean esCorrecto() {
        return correcto;
    }

    public Enfermedad getEnfermedadSospechada() {
        return enfermedadSospechada;
    }

    public List<String> getSintomasObservados() {
        return sintomasObservados;
    }
}

