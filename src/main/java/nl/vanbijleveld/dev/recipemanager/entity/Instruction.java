package nl.vanbijleveld.dev.recipemanager.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import nl.vanbijleveld.dev.recipemanager.enums.ActionEnum;

import java.util.List;

@Getter
@Setter
@Builder
public class Instruction {

    private Integer step;
    private ActionEnum action;
    private String description;
    private List<Ingredient> ingredients;
    private Integer duration;

}
