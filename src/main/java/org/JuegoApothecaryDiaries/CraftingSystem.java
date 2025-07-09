package org.JuegoApothecaryDiaries;

import java.util.*;

import java.util.*;

class Recipe {
    String name;
    Set<String> ingredients;

    Recipe(String name, String... ingredients) {
        this.name = name;
        this.ingredients = new HashSet<>(Arrays.asList(ingredients));
    }

    boolean matches(Set<String> input) {
        return ingredients.equals(input);
    }
}

public class CraftingSystem {
    static List<Recipe> knownRecipes = new ArrayList<>();

    static {
        knownRecipes.add(new Recipe("Antídoto básico", "Flor azul", "Raíz amarga"));
        knownRecipes.add(new Recipe("Ungüento curativo", "Hoja roja", "Miel silvestre"));
    }

    public static void main(String[] args) {
        Set<String> input = new HashSet<>();
        input.add("Flor azul");
        input.add("Raíz amarga");

        for (Recipe recipe : knownRecipes) {
            if (recipe.matches(input)) {
                System.out.println("¡Has creado: " + recipe.name + "!");
                return;
            }
        }

        System.out.println("Los ingredientes no reaccionan...");
    }
}




