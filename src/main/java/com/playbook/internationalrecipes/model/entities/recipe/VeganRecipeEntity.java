package com.playbook.internationalrecipes.model.entities.recipe;

import lombok.Data;

@Data
public class VeganRecipeEntity extends RecipeEntity {
    private boolean isVegan;
}
