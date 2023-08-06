package nl.vanbijleveld.dev.recipemanager.dao;

import nl.vanbijleveld.dev.recipemanager.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
