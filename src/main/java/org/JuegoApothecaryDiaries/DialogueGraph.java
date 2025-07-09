package org.JuegoApothecaryDiaries;

import java.util.ArrayList;
import java.util.List;

public class DialogueGraph {
    private List<DialogueNode> nodos;

    public DialogueGraph() {
        this.nodos = new ArrayList<>();
    }

    public void agregarNodo(DialogueNode nodo) {
        nodos.add(nodo);
    }

    public boolean estaNodo(DialogueNode nodo){
        return nodos.contains(nodo);
    }

    public DialogueNode getNodoPorId(String id) {
        for (DialogueNode nodo : nodos) {
            if (nodo.getId().equals(id)) return nodo;
        }
        return null;
    }

    public List<DialogueNode> getNodos() {
        return nodos;
    }
}