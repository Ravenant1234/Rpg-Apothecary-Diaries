package org.JuegoApothecaryDiaries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personaje {
    protected String nombre;
    protected int nivel;
    protected int inteligencia;
    protected int percepcion;

    protected int carisma;
    protected int curiosidad;

    private List<Item> inventario;
    private List<EntradaDiario> diario;
    private Map<String, Integer> reputacion;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.nivel = 1;
        inventario = new ArrayList<>();
        diario = new ArrayList<>();
        reputacion = new HashMap<>();
        // Inicialización con stats base (personalizable)
    }

    public void aumentarReputacion(String clave, int cantidad) {
        reputacion.put(clave, reputacion.getOrDefault(clave, 0) + cantidad);
    }

    public void agregarItem(Item item) {
        inventario.add(item);
    }

    public void anotarDiario(String observacion) {
        diario.add(new EntradaDiario(observacion));
    }

    public void setNombre(String nom){
        nombre = nom;
    }

    public void setDiario(List<EntradaDiario> d){
        diario = d;
    }

    public void setReputacion(String nombrePersonaje, int reputacion){
        if ((this.reputacion.get(nombrePersonaje)) != null)
            this.reputacion.put(nombrePersonaje,reputacion);
    }

    public void aumentarReputacion (Personaje p){
        if (reputacion.get(p.getNombre()) != null)
                reputacion.put(p.getNombre(),reputacion.get(p.getNombre()) + 1);
    }

    public String getNombre() {
        return nombre;
    }

    public List<EntradaDiario> getDiario(){
        return diario;
    }

    public Map<String,Integer> getReputacion(){
        return reputacion;
    }

    public List<Item> getInventario(){
        return inventario;
    }
}
