package model.recipe;

import lombok.Data;

import java.util.List;

@Data
public class Recipe {
    private String name;
    private String description;
    private List<String> ingredients;
    private String instructions;
    private String country;
    private Integer prepTime;
}
