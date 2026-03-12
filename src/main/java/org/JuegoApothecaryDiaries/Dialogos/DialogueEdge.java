package org.JuegoApothecaryDiaries.Dialogos;

import java.util.function.Predicate;

import org.JuegoApothecaryDiaries.Logica.GameState;

public class DialogueEdge {
    private String textoOpcion;
    private String destinoId; // ID del nodo destino
    private Predicate<GameState> condicion; // (opcional) condición para desbloquear
    private int reputacion;

    public DialogueEdge(String textoOpcion, DialogueNode destino, int reputacion, Predicate<GameState> condicion) {
        this.textoOpcion = textoOpcion;
        this.destinoId = destino.getId();
        this.condicion = condicion;
        this.reputacion = reputacion;
    }

    public DialogueEdge(String textoOpcion, DialogueNode destino, int reputacion) {
        this(textoOpcion, destino, reputacion, estado -> true);
    }

    public int getWeight() {
        return reputacion;
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

    public int getReputacion() {
        return reputacion;
    }
}
