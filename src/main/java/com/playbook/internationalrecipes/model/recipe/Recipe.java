package com.playbook.internationalrecipes.model.recipe;

import com.playbook.internationalrecipes.model.author.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Recipe {

    private String id;
    private String name;
    private String description;
    private List<String> ingredients;
    private String instructions;
    private String country;
    private Integer prepTime;
    private Author author;
}
