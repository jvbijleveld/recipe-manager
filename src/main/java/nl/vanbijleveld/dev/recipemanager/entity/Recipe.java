package nl.vanbijleveld.dev.recipemanager.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Recipe {

    private Long id;
    private String name;
    private List<Instruction> instructions;

}
