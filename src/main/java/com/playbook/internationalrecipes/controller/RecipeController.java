package com.playbook.internationalrecipes.controller;

import com.playbook.internationalrecipes.model.dtos.recipeDtos.RecipeDTO;
import com.playbook.internationalrecipes.model.entities.recipe.RecipeEntity;
import com.playbook.internationalrecipes.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/recipeCreate")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRecipe(@RequestBody RecipeDTO recipeDTO) {
        recipeService.createRecipe(recipeDTO);
    }

    @GetMapping("/{id}")
    public Optional<RecipeEntity> getRecipe(@PathVariable Long id) {
        return recipeService.getRecipe(id);
    }

    @GetMapping
    public List<RecipeEntity> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PutMapping("/{id}")
    public void updateRecipe(@PathVariable Long id, @RequestBody RecipeDTO recipeUpdateDTO){
        recipeService.updateRecipe(id,recipeUpdateDTO);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }


}
