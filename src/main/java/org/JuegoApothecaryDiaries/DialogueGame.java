package org.JuegoApothecaryDiaries;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DialogueGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Maomao m = new Maomao();
        GameState state = new GameState(m);


                                    DialogueGraph grafo;

                                    DialogueNode n1 = new DialogueNode("1", "¿Te sentís bien?");
                                    n1.addOption(new DialogueEdge("Sí, sólo cansada.", "2",state->state.));
                                    n1.addOption(new DialogueEdge("No, tengo un fuerte dolor de cabeza.", "3"));

                                    // Nodo 2
                                    DialogueNode n2 = new DialogueNode("2", "Deberías descansar un poco más.");

                                    // Nodo 3
                                    DialogueNode n3 = new DialogueNode("3", "Hmm... eso puede ser un síntoma de fiebre del loto.");

                                    // Agregar nodos al grafo
                                    grafo.agregarNodo(n1);
                                    grafo.agregarNodo(n2);
                                    grafo.agregarNodo(n3);

        DialogueGraph grafoDialogo = new DialogueGraph();

        // Nodos
        DialogueNode intro = new DialogueNode("intro", "Guardia: ¿Qué hacés merodeando por acá?");
        DialogueNode confianza = new DialogueNode("confianza", "Guardia: Sos de fiar. Pasá.");
        DialogueNode sospecha = new DialogueNode("sospecha", "Guardia: Hmm... no me convence.");
        DialogueNode detencion = new DialogueNode("detencion", "Guardia: ¡Guardias, este sujeto es sospechoso!");

        grafoDialogo.agregarNodo(intro);




        // Transiciones
        intro.addOption(new DialogueEdge("Decir la verdad", , confianza, +5));
        intro.addOption(new DialogueEdge("Mentir", , sospecha, -5));

        sospecha.addOption(new DialogueEdge("Insistir con una excusa", , detencion, -5));
        sospecha.addOption(new DialogueEdge("Decir la verdad ahora", confianza, +3));

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
            state.applyWeight("guardia", selected.getWeight());
            current = selected.getTarget();
        }

        int reputacionGuardia = state.getScore("guardia");

        System.out.println("\nReputación con el guardia: " + reputacionGuardia);

        if (reputacionGuardia >= 5) {
            System.out.println("Resultado: ¡Ganaste la confianza del guardia!");
        } else if (reputacionGuardia <= -5) {
            System.out.println("Resultado: Sos arrestado por sospechoso.");
        } else {
            System.out.println("Resultado: El guardia te sigue vigilando...");
        }
    }
}