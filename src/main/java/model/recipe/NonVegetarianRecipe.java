package model.recipe;

import lombok.Data;

@Data
public class NonVegetarianRecipe extends Recipe {
    private String meatType; //TODO:It can be enum

}
