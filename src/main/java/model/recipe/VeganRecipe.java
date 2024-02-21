package model.recipe;

import lombok.Data;
import model.recipe.Recipe;

@Data
public class VeganRecipe extends Recipe {
    private boolean isVegan;
}
