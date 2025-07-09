package org.JuegoApothecaryDiaries;

import java.time.LocalDate;

public class EntradaDiarioReceta extends EntradaDiario{

    public EntradaDiarioReceta(String titulo, String descripcion, LocalDate fecha) {
        super(titulo, descripcion, fecha, TipoEntrada.RECETA);
    }
}
