package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.entities.recipe.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresDbRecipeRepository extends JpaRepository<RecipeEntity, Long> {

}
