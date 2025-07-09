package org.JuegoApothecaryDiaries;

import java.util.function.Predicate;

public class DialogueEdge {
    private String textoOpcion;
    private String destinoId; // ID del nodo destino
    private Predicate<GameState> condicion; // (opcional) condición para desbloquear

    public DialogueEdge(String textoOpcion, String destinoId, Predicate<GameState> condicion) {
        this.textoOpcion = textoOpcion;
        this.destinoId = destinoId;
        this.condicion = condicion;
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
}
