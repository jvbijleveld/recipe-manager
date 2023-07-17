package nl.vanbijleveld.dev.recipemanager.dao;

import nl.vanbijleveld.dev.recipemanager.entity.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeDao extends CrudRepository<Recipe, Long> {
}
