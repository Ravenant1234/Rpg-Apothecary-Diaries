package org.JuegoApothecaryDiaries;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Grimorio {
    private List<EntradaDiario> entradas;

    public Grimorio() {
        this.entradas = new ArrayList<>();
    }

    public void agregarEntrada(EntradaDiario entrada) {
        entradas.add(entrada);
    }

    public List<EntradaDiario> getEntradas() {
        return entradas;
    }

    public List<EntradaDiario> buscarPorTipo(TipoEntrada tipo) {
        return entradas.stream()
                .filter(e -> e.getTipo() == tipo)
                .collect(Collectors.toList());
    }

    public boolean estaEntradaDiario (EntradaDiario e){
        Iterator i = entradas.listIterator();
        boolean encontre = false;
        while (i.hasNext() && !encontre)
            encontre = e == (EntradaDiario) i.next();
        return encontre;
    }

    public void imprimirTodo() {
        for (EntradaDiario e : entradas) {
            System.out.println(e);
        }
    }
}
