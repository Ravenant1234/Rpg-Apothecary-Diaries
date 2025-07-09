package org.JuegoApothecaryDiaries;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sintoma {
    @JsonProperty("descripcion")
    private String descripcion;

    //Constructor vacio necesario para JSON PARA FUNCIONAR
    public Sintoma(){}
    public Sintoma(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}

