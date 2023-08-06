package nl.vanbijleveld.dev.recipemanager.service;

import lombok.AllArgsConstructor;
import nl.vanbijleveld.dev.recipemanager.dao.RecipeRepository;
import nl.vanbijleveld.dev.recipemanager.entity.Ingredient;
import nl.vanbijleveld.dev.recipemanager.entity.Instruction;
import nl.vanbijleveld.dev.recipemanager.entity.Recipe;
import nl.vanbijleveld.dev.recipemanager.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public Recipe createNewRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Long id, Recipe recipe) {
        var currentRecipe = recipeRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

        currentRecipe.setName(recipe.getName());
        currentRecipe.setDescription(recipe.getDescription());
        currentRecipe.setServes(recipe.getServes());
        currentRecipe.setInstructions(mapInstructions(currentRecipe, recipe.getInstructions()));
        return recipeRepository.save(currentRecipe);
    }

    private List<Instruction> mapInstructions(Recipe recipe, List<Instruction> newInstructions) {

       return newInstructions.stream().map(instruction ->
            recipe.getInstructions().stream()
                    .filter(ci -> Objects.equals(ci.getStep(), instruction.getStep()))
                    .findFirst().map(newInstruction -> {
                        newInstruction.setDescription(instruction.getDescription());
                        newInstruction.setAction(instruction.getAction());
                        newInstruction.setDuration(instruction.getDuration());
                        newInstruction.setAppliance(instruction.getAppliance());
                        newInstruction.setIngredients(mapIngredients(newInstruction, instruction.getIngredients()));
                        return newInstruction;
                    }).orElseGet(() ->
                        Instruction.builder()
                                .step(instruction.getStep())
                                .action(instruction.getAction())
                                .duration(instruction.getDuration())
                                .appliance(instruction.getAppliance())
                                .ingredients(instruction.getIngredients())
                                .build()
                    )
        ).collect(Collectors.toList());
    }

    private List<Ingredient> mapIngredients(Instruction instruction, List<Ingredient> newIngredients) {
        return newIngredients.stream().map(ingredient ->
                instruction.getIngredients().stream()
                        .filter(ing -> Objects.equals(ing.getId(), ingredient.getId()))
                        .findFirst().map(newIngredient -> {
                            newIngredient.setIngredientName(ingredient.getIngredientName());
                            newIngredient.setAmount(ingredient.getAmount());
                            newIngredient.setUnit(ingredient.getUnit());
                            return newIngredient;
                        }).orElseGet(() -> Ingredient.builder()
                                    .ingredientName(ingredient.getIngredientName())
                                    .amount(ingredient.getAmount())
                                    .unit(ingredient.getUnit())
                                    .build()
                        )
                ).collect(Collectors.toList());
    }

}
