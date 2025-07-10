package org.JuegoApothecaryDiaries;

import java.util.function.Predicate;

public class DialogueEdge {
    private String textoOpcion;
    private String destinoId; // ID del nodo destino
    private Predicate<GameState> condicion; // (opcional) condición para desbloquear
    private int reputacion;

    public DialogueEdge(String textoOpcion, DialogueNode destino, int reputacion) {
        this.textoOpcion = textoOpcion;
        this.destinoId = destino.getId();
        this.condicion = estado -> true;
        this.reputacion = reputacion;
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
}
