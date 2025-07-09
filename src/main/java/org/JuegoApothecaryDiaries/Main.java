package org.JuegoApothecaryDiaries;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Enfermedad> enfermedades = null;
        try {
            enfermedades = CargadorDeEnfermedades.cargar("C:\\Users\\PC\\IdeaProjects\\untitled\\src\\main\\resources\\enfermedades.json");
        }catch(Exception e){
            System.out.println("Error en la carga");
        }
        for (Enfermedad e : enfermedades) {
            System.out.println("🧪 " + e.getNombre() + " (" + e.getDificultad() + ")");
            for (Sintoma sintoma : e.getSintomas()) {
                System.out.println(" - " + sintoma.toString());
            }
            System.out.println("");
        }
    }
}
