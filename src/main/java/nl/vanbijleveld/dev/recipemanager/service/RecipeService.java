package nl.vanbijleveld.dev.recipemanager.service;

import lombok.AllArgsConstructor;
import nl.vanbijleveld.dev.recipemanager.dao.RecipeRepository;
import nl.vanbijleveld.dev.recipemanager.entity.Recipe;
import nl.vanbijleveld.dev.recipemanager.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public List<Recipe> findAllRecipes() {
        return recipeRepository.findAll().stream().toList();
    }

    public Recipe getRecipeById(Long recipeId) {
        return recipeRepository.findById(recipeId).orElseThrow(ResourceNotFoundException::new);
    }

}
