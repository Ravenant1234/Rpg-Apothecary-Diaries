package org.JuegoApothecaryDiaries;

import java.util.function.Predicate;

public class DialogueEdge {
    private String textoOpcion;
    private String destinoId; // ID del nodo destino
    private Predicate<GameState> condicion; // (opcional) condición para desbloquear
    private int reputacion;
    private double weight; // Add weight

    public DialogueEdge(String textoOpcion, DialogueNode destino, int reputacion, double weight) {
        this.textoOpcion = textoOpcion;
        this.destinoId = destino.getId();
        this.condicion = estado -> true;
        this.reputacion = reputacion;
        this.weight = weight;
    }

    public String getTextoOpcion() {
        return textoOpcion;
    }

    public String getDestinoId() {
        return destinoId;
    }

    public boolean estaDisponible(GameState estado) {
        return condicion == null || condicion.test(estado);
    }

    public Predicate<GameState> getCondicion() {
        return condicion;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
