package org.JuegoApothecaryDiaries.Logica;

import org.JuegoApothecaryDiaries.Personajes.Maomao;

public class Juego {
    public static GameState estadoActual;

    public static void main(String[] args) {
        Maomao maomao = new Maomao();
        estadoActual = new GameState(maomao);
        estadoActual.activarEvento(new Evento(Evento.TipoEvento.HALLAZGO_ITEM, "Descubrimiento de raíz de loto", "Maomao encuentra una raíz de loto en el bosque, conocida por sus propiedades medicinales.", maomao));

        maomao.agregarItem(new Item("Raíz de loto", "Utilizada para reducir fiebres",TipoItem.PLANTA));
        maomao.anotarDiario("El paciente tenía manchas azules en la lengua... posible intoxicación");

        System.out.println("Diario de Maomao:");
        for (EntradaDiario entrada : maomao.getDiario()) {
            System.out.println("- " + entrada.getTexto());
        }
    }
}
