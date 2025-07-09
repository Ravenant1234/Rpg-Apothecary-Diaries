package org.JuegoApothecaryDiaries;

import java.util.Date;

public class EntradaDiario {
    private String texto;
    private Date fecha;

    public EntradaDiario(String texto) {
        this.texto = texto;
        this.fecha = new Date();
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getTexto() {
        return texto;
    }
}
