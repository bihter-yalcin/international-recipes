package com.playbook.internationalrecipes.model.entities.recipe;

import lombok.Data;

@Data
public class NonVegetarianRecipeEntity extends RecipeEntity {
    private String meatType; //TODO:It can be enum

}
