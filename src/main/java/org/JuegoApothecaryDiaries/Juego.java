package org.JuegoApothecaryDiaries;

public class Juego {
    public static void main(String[] args) {
        Maomao protagonista = new Maomao();
        protagonista.agregarItem(new Item("Raíz de loto", "Utilizada para reducir fiebres"));
        protagonista.anotarDiario("El paciente tenía manchas azules en la lengua... posible intoxicación");

        System.out.println("Diario de Maomao:");
        for (EntradaDiario entrada : protagonista.getDiario()) {
            System.out.println("- " + entrada.getTexto());
        }
    }
}
