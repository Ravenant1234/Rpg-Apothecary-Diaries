package org.JuegoApothecaryDiaries;

import java.util.*;

class Recipe {


    private String name;
    private Set<String> ingredients;

    public Recipe(String name, String... ingredients) {
        this.name = name;
        this.ingredients = new HashSet<>(Arrays.asList(ingredients));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean matches(Set<String> input) {
        return ingredients.equals(input);
    }
}

public class CraftingSystem {
    private static List<Recipe> knownRecipes = new ArrayList<>();

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
                System.out.println("¡Has creado: " + recipe.getName() + "!");
                return;
            }
        }

        System.out.println("Los ingredientes no reaccionan...");
    }
}




