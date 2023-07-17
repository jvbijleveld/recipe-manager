package nl.vanbijleveld.dev.recipemanager.controller;

import nl.vanbijleveld.dev.recipemanager.entity.Recipe;
import nl.vanbijleveld.dev.recipemanager.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping(value = "/recipe/{recipeId}")
    public Recipe getRecipe(@PathVariable Long recipeId) {
        return recipeService.findRecipe(recipeId);
    }

}
