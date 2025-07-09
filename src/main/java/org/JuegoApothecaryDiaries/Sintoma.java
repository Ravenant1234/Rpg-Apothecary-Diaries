package org.JuegoApothecaryDiaries;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sintoma {
    @JsonProperty("descripcion")
    private String descripcion;
    private int nivelVisible;


    //Constructor vacio necesario para JSON PARA FUNCIONAR
    public Sintoma(){}
    public Sintoma(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }

    public boolean esVisiblePara(int conocimiento) {
        return conocimiento >= nivelVisible;
    }

    public String getDescripcion(){
        return descripcion;
    }

}

