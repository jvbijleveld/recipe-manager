package nl.vanbijleveld.dev.recipemanager.controller;

import nl.vanbijleveld.dev.recipemanager.entity.Recipe;
import nl.vanbijleveld.dev.recipemanager.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping(value = "/recipe")
    public List<Recipe> getAllRecipes() {
        return recipeService.findAllRecipes();
    }

    @GetMapping(value = "/recipe/{recipeId}")
    public Recipe getRecipe(@PathVariable Long recipeId) {
        return recipeService.getRecipeById(recipeId);
    }

    @PutMapping(value = "/recipe")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createNewRecipe(recipe);
    }

    @PostMapping(value = "/recipe/{recipeId}")
    public Recipe updateRecipe(@PathVariable Long recipeId, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(recipeId, recipe);
    }

}
