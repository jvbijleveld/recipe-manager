package nl.vanbijleveld.dev.recipemanager.service;

import nl.vanbijleveld.dev.recipemanager.dao.RecipeDao;
import nl.vanbijleveld.dev.recipemanager.entity.Recipe;
import nl.vanbijleveld.dev.recipemanager.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecipeService {

    @Autowired
    private RecipeDao recipeDao;

    public List<Recipe> findAllRecipes() {
        return StreamSupport.stream(recipeDao.findAll().spliterator(), false).toList();
    }

    public Recipe getRecipeById(Long recipeId) {
        return recipeDao.findById(recipeId).orElseThrow(ResourceNotFoundException::new);
    }

}
