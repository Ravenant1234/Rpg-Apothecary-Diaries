package org.JuegoApothecaryDiaries;

public class Diagnostico {

    public static boolean intentarDiagnosticar(Maomao m, Enfermedad e) {
        int base = (m.inteligencia + m.percepcion + m.conocimientoHerbal) / 3;
        int modificador = (int) (Math.random() * 6 - 2); // entre -2 y +3
        int resultado = base + modificador;

        System.out.println("⚗️ Maomao analiza los síntomas...");

        if (resultado >= e.getDificultad() + 2) {
            System.out.println("✅ Diagnóstico exitoso: " + e.getNombre());
            return true;
        } else if (resultado >= e.getDificultad() - 2) {
            System.out.println("❔ Diagnóstico incierto, pero posible sospecha: " + e.getNombre());
            return false;
        } else {
            System.out.println("❌ Diagnóstico fallido.");
            return false;
        }
    }
}
