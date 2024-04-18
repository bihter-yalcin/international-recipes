package com.playbook.internationalrecipes.model.Requests.RecipeRequests;

import com.playbook.internationalrecipes.model.author.Author;
import lombok.Data;

import java.util.List;

@Data
public class RecipeCreateRequest {
    private String name;
    private String description;
    private List<String> ingredients;
    private String instructions;
    private String country;
    private Integer prepTime;
    private Author author;
}
