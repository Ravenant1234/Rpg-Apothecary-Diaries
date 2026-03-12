package org.JuegoApothecaryDiaries.Logica;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import org.JuegoApothecaryDiaries.Personajes.Maomao;

public class GameState {
    private Map<String, Integer> scores = new HashMap<>();

    private Maomao maomao;
    private String ubicacionActual;
    private Set<Evento> eventos; //CAMBIAR EVENTOS ACTIVADOS A EVENTOS Y PONER CHECKS DE ACTIVADO, DESACTIVADO
    
    //Set<Evento> es mejor
    //Evento puede tener un enum "tipo" donde tipo puede ser "Quest", "Hallazgo", etc
    //Y cada tipo de evento, por ejemplo "Quest", "Hallazgo" tiene un id que lo identifica y una descripcion y los "participantes" como una referencia a objetos
    //private Set<Evento> eventosActivados;
    
    private int dia;

    public GameState(Maomao maomao) {
        this.maomao = maomao;
        this.ubicacionActual = "Palacio Central";
        this.eventos = new HashSet<>();
        this.dia = 1;
    }

    boolean evaluate (Predicate<GameState> p){
        return p == null || p.test(this);
    }

    boolean evaluate(String condition) {
        if (condition == null || condition.isEmpty()) return true;
        for (String part : condition.split("&&")) {
            part = part.trim();
            if (part.startsWith("!")) {
                if (eventos.contains(part.substring(1))) return false;
            } else {
                if (!eventos.contains(part)) return false;
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
    public Set<Evento> getEventosActivados() { 
        Set<Evento> activados = new HashSet<>();
        for (Evento evento : eventos) {
            if (evento.estaActivado()) {
                activados.add(evento);
            }
        }
        return activados;
     }
    public int getDia() { return dia; }

    public void setUbicacionActual(String ubicacion) {
        this.ubicacionActual = ubicacion;
    }

    public void avanzarDia() {
        dia++;
    }

    public void activarEvento(String id) {
        for (Evento evento : eventos) {
            if (evento.getId().equals(id)) {
                evento.activarEvento();
                break;
            }
        }
    }

    public boolean estaEventoActivo(String evento) {
        return eventos.stream().anyMatch(e -> e.getId().equals(evento) && e.estaActivado());
    }

}



