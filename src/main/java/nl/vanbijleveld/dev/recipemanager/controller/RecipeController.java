package nl.vanbijleveld.dev.recipemanager.controller;

import nl.vanbijleveld.dev.recipemanager.entity.Ingredient;
import nl.vanbijleveld.dev.recipemanager.entity.Instruction;
import nl.vanbijleveld.dev.recipemanager.entity.Recipe;
import nl.vanbijleveld.dev.recipemanager.enums.ActionEnum;
import nl.vanbijleveld.dev.recipemanager.enums.UnitEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static nl.vanbijleveld.dev.recipemanager.fixture.RecipeFixture.mockRecipe;

@RequestMapping(value = "/recipe")
@RestController
public class RecipeController {

@GetMapping(value = "/{recipeId}")
    public Recipe getRecipe(@PathVariable Long recipeId) {

        return mockRecipe(recipeId);
    }

}