package org.JuegoApothecaryDiaries;

import java.time.LocalDate;

public class EntradaDiario {
    private String titulo;
    private String descripcion;
    private LocalDate fecha;
    private TipoEntrada tipo;

    public EntradaDiario(String titulo, String descripcion, LocalDate fecha, TipoEntrada tipo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public LocalDate getFecha() { return fecha; }
    public TipoEntrada getTipo() { return tipo; }

    @Override
    public String toString() {
        return "[" + tipo + "] " + titulo + " (" + fecha + "):\n" + descripcion + "\n";
    }
}
