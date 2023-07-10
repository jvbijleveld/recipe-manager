package nl.vanbijleveld.dev.recipemanager.fixture;

import nl.vanbijleveld.dev.recipemanager.entity.Ingredient;
import nl.vanbijleveld.dev.recipemanager.entity.Instruction;
import nl.vanbijleveld.dev.recipemanager.entity.Recipe;
import nl.vanbijleveld.dev.recipemanager.enums.ActionEnum;
import nl.vanbijleveld.dev.recipemanager.enums.UnitEnum;

import java.util.List;

public class RecipeFixture {

    private RecipeFixture() {
        //not implemented
    }

    public static Recipe mockRecipe(Long id) {
        List<Ingredient> ingredients = getIngredients();
        List<Instruction> instructions = getInstructionList(ingredients);

        return Recipe.builder()
                .id(id)
                .name("Mock Recipe")
                .instructions(instructions)
                .build();
    }

    private static List<Instruction> getInstructionList(List<Ingredient> ingredients) {
        return List.of(Instruction.builder()
                        .step(1)
                        .ingredients(ingredients)
                        .action(ActionEnum.ADD_INGREDIENT)
                        .description("Add the ingredients in a bowl")
                        .build(),
                Instruction.builder()
                        .step(2)
                        .description("Whisk until smooth texture")
                        .duration(300)
                        .action(ActionEnum.WHISK).build(),
                Instruction.builder()
                        .step(3)
                        .action(ActionEnum.BAKE)
                        .description("Bake until golden brown, flip halfway")
                        .duration(180)
                        .build(),
                Instruction.builder()
                        .step(4).action(ActionEnum.SERVE).ingredients(List.of(Ingredient.builder().ingredientName("Maple Syrup").amount(1).unit(UnitEnum.SPOON).build())).build());
    }

    private static List<Ingredient> getIngredients() {
        return List.of(Ingredient.builder()
                        .ingredientName("Flower")
                        .amount(300)
                        .unit(UnitEnum.GRAMS)
                        .build(),
                Ingredient.builder()
                        .ingredientName("Milk")
                        .amount(150)
                        .unit(UnitEnum.MILILITERS)
                        .build(),
                Ingredient.builder()
                        .ingredientName("Egg")
                        .amount(2)
                        .unit(UnitEnum.PIECE)
                        .build());
    }
}
