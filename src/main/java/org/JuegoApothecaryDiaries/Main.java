package org.JuegoApothecaryDiaries;

import java.util.List;

import org.JuegoApothecaryDiaries.Logica.CargadorDeEnfermedades;
import org.JuegoApothecaryDiaries.Logica.DiagnosticoUtil;
import org.JuegoApothecaryDiaries.Logica.Enfermedad;
import org.JuegoApothecaryDiaries.Personajes.Maomao;

public class Main {
    public static void main(String[] args) {
        List<Enfermedad> enfermedades = null;
        try {
            enfermedades = CargadorDeEnfermedades.cargar("C:\\Users\\PC\\IdeaProjects\\untitled\\src\\main\\resources\\enfermedades.json");
        }catch(Exception e){
            System.out.println("Error en la carga");
        }
        Maomao maomao = new Maomao();

        Enfermedad e = enfermedades.get(0);
        DiagnosticoUtil.registrarDiagnostico(maomao, e);

        maomao.getGrimorio().imprimirTodo();
    }
}
