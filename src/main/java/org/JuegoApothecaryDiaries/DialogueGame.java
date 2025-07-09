package org.JuegoApothecaryDiaries;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DialogueGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GameState state = new GameState();

        // Nodos
        DialogueNode intro = new DialogueNode("intro", "Guardia: ¿Qué hacés merodeando por acá?");
        DialogueNode confianza = new DialogueNode("confianza", "Guardia: Sos de fiar. Pasá.");
        DialogueNode sospecha = new DialogueNode("sospecha", "Guardia: Hmm... no me convence.");
        DialogueNode detencion = new DialogueNode("detencion", "Guardia: ¡Guardias, este sujeto es sospechoso!");

        // Transiciones
        intro.addOption(new DialogueEdge("Decir la verdad", "", confianza, +5));
        intro.addOption(new DialogueEdge("Mentir", "", sospecha, -5));

        sospecha.addOption(new DialogueEdge("Insistir con una excusa", "", detencion, -5));
        sospecha.addOption(new DialogueEdge("Decir la verdad ahora", "", confianza, +3));

        // Diálogo
        DialogueNode current = intro;
        while (current != null) {
            System.out.println("\n" + current.getText());
            if (current.getOptions().isEmpty()) break;

            List<DialogueEdge> valid = new ArrayList<>();
            for (DialogueEdge edge : current.getOptions()) {
                if (state.evaluate(edge.getCondition())) {
                    valid.add(edge);
                }
            }

            for (int i = 0; i < valid.size(); i++) {
                System.out.println((i + 1) + ". " + valid.get(i).getChoiceText());
            }

            System.out.print("> ");
            int choice = in.nextInt() - 1;
            DialogueEdge selected = valid.get(choice);
            state.applyWeight("guardia", selected.weight);
            current = selected.getTarget();
        }

        System.out.println("\nReputación con el guardia: " + state.getScore("guardia"));

        if (state.getScore("guardia") >= 5) {
            System.out.println("Resultado: ¡Ganaste la confianza del guardia!");
        } else if (state.getScore("guardia") <= -5) {
            System.out.println("Resultado: Sos arrestado por sospechoso.");
        } else {
            System.out.println("Resultado: El guardia te sigue vigilando...");
        }
    }
}