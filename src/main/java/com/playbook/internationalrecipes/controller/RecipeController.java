package com.playbook.internationalrecipes.controller;

import com.playbook.internationalrecipes.model.Requests.RecipeRequests.RecipeCreateRequest;
import com.playbook.internationalrecipes.model.recipe.Recipe;
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
    public void createRecipe(@RequestBody RecipeCreateRequest request) {
        recipeService.createRecipe(request);
    }

    @GetMapping("/{id}")
    public Optional<Recipe> getRecipe(@PathVariable Long id) {
        return recipeService.getRecipe(id);
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }


}
