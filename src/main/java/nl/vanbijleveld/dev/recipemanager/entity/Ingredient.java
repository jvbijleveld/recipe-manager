package nl.vanbijleveld.dev.recipemanager.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import nl.vanbijleveld.dev.recipemanager.enums.UnitEnum;

@Getter
@Setter
@Builder
public class Ingredient {

    private String ingredientName;
    private Integer amount;
    private UnitEnum unit;

}
