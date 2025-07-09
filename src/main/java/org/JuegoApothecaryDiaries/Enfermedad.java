package org.JuegoApothecaryDiaries;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Enfermedad {
    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("dificultad")
    private int dificultad; // 1 a 10, para cálculo de éxito
    @JsonProperty("sintomas")
    private List<Sintoma> sintomas;

    public Enfermedad(){}
    public Enfermedad(String nombre, int dificultad, List<Sintoma> sintomas) {
        this.nombre = nombre;
        this.sintomas = sintomas;
        this.dificultad = dificultad;
    }

    public String getNombre(){
        return nombre;
    }

    public int getDificultad() {
        return dificultad;
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }
}