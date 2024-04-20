package com.playbook.internationalrecipes.model.dtos.recipeDtos;

import com.playbook.internationalrecipes.model.dtos.authorDtos.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeDTO {
    private Long id;
    private String name;
    private String description;
    private List<String> ingredients;
    private String instructions;
    private String country;
    private Integer prepTime;
    private AuthorDTO authorDTO;
}
