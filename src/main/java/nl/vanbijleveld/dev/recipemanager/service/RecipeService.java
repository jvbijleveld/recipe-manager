package nl.vanbijleveld.dev.recipemanager.service;

import nl.vanbijleveld.dev.recipemanager.dao.RecipeDao;
import nl.vanbijleveld.dev.recipemanager.entity.Recipe;
import nl.vanbijleveld.dev.recipemanager.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    private RecipeDao recipeDao;

    public Recipe findRecipe(Long recipeId) {
        return recipeDao.findById(recipeId).orElseThrow(ResourceNotFoundException::new);
    }

}
