package org.JuegoApothecaryDiaries;

public class Item {
    private String nombre;
    private String descripcion;
    private TipoItem tipo;

    public Item(String nombre, String descripcion, TipoItem tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoItem getTipo(){
        return tipo;
    }

    public void setTipo (TipoItem tipo){
        this.tipo = tipo;
    }
}

