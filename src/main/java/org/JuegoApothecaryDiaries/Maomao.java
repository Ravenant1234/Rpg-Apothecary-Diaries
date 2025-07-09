package org.JuegoApothecaryDiaries;

public class Maomao extends Personaje {
    protected int conocimientoHerbal;
    protected int resistenciaVenenos;

    public Maomao() {
        super("Maomao");
        this.inteligencia = 9;
        this.percepcion = 8;
        this.conocimientoHerbal = 10;
        this.resistenciaVenenos = 7;
        this.carisma = 4;
        this.curiosidad = 9;
    }
}
