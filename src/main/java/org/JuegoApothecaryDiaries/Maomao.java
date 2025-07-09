package org.JuegoApothecaryDiaries;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Maomao extends Personaje {
    protected int conocimientoHerbal;
    protected int resistenciaVenenos;

    private Grimorio g;

    public Maomao() {
        super("Maomao");
        this.inteligencia = 9;
        this.percepcion = 8;
        this.conocimientoHerbal = 10;
        this.resistenciaVenenos = 7;
        this.carisma = 4;
        this.curiosidad = 9;
        g = new Grimorio();
    }

    public void agregarAGrimorio (EntradaDiario e){
        g.agregarEntrada(e);
    }

    public Grimorio getGrimorio(){
        return g;
    }

    public boolean estaEnGrimorio (EntradaDiario e){
        return g.estaEntradaDiario(e);
    }

    public List<String> detectarSintomas(Enfermedad enfermedad) {
        return enfermedad.getSintomas().stream()
                .filter(s -> s.esVisiblePara(this.conocimientoHerbal))
                .map(Sintoma::getDescripcion)
                .collect(Collectors.toList());
    }

}
