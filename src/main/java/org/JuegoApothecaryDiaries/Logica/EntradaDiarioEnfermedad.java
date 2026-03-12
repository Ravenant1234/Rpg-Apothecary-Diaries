package org.JuegoApothecaryDiaries.Logica;

import java.time.LocalDate;

public class EntradaDiarioEnfermedad extends EntradaDiario{

    public EntradaDiarioEnfermedad(String titulo, String descripcion, LocalDate fecha) {
        super(titulo, descripcion, fecha, TipoEntrada.ENFERMEDAD);
    }
}
