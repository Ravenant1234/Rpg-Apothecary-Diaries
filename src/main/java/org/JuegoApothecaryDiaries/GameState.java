package org.JuegoApothecaryDiaries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class GameState {
    private Set<String> flags = new HashSet<>();
    private Map<String, Integer> scores = new HashMap<>();

    private Maomao maomao;
    private String ubicacionActual;
    private Set<String> eventosActivados;
    private int dia;

    public GameState(Maomao maomao) {
        this.maomao = maomao;
        this.ubicacionActual = "Palacio Central";
        this.eventosActivados = new HashSet<>();
        this.dia = 1;
    }

    boolean evaluate (Predicate<GameState> p){

    }
    boolean evaluate(String condition) {
        if (condition == null || condition.isEmpty()) return true;
        for (String part : condition.split("&&")) {
            part = part.trim();
            if (part.startsWith("!")) {
                if (flags.contains(part.substring(1))) return false;
            } else {
                if (!flags.contains(part)) return false;
            }
        }
        return true;
    }

    void applyWeight(String key, int value) {
        scores.put(key, scores.getOrDefault(key, 0) + value);
    }

    int getScore(String key) {
        return scores.getOrDefault(key, 0);
    }





    public Maomao getMaomao() { return maomao; }
    public String getUbicacionActual() { return ubicacionActual; }
    public Set<String> getEventosActivados() { return eventosActivados; }
    public int getDia() { return dia; }

    public void setUbicacionActual(String ubicacion) {
        this.ubicacionActual = ubicacion;
    }

    public void avanzarDia() {
        dia++;
    }

    public void activarEvento(String evento) {
        eventosActivados.add(evento);
    }

    public boolean estaEventoActivo(String evento) {
        return eventosActivados.contains(evento);
    }
}