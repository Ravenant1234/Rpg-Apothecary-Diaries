package org.JuegoApothecaryDiaries;

import java.util.*;

public class Grimorio {
    private Map<String, String> entradas = new HashMap<>();

    public void registrar(String nombre, String descripcion) {
        entradas.put(nombre, descripcion);
    }

    public void mostrar() {
        System.out.println("--- GRIMORIO ---");
        for (Map.Entry<String, String> entry : entradas.entrySet()) {
            System.out.println("• " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Grimorio g = new Grimorio();
        g.registrar("Flor azul", "Planta que calma fiebres leves.");
        g.registrar("Antídoto básico", "Neutraliza venenos comunes.");
        g.mostrar();
    }
}
