package com.playbook.internationalrecipes.model.recipe;

import com.playbook.internationalrecipes.model.author.Author;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    private Long id;
    private String name;
    private String description;
    private List<String> ingredients;
    private String instructions;
    private String country;
    private Integer prepTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;
}
