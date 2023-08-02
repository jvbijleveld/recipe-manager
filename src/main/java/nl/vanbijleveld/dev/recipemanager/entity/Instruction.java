package nl.vanbijleveld.dev.recipemanager.entity;

import jakarta.persistence.*;
import lombok.*;
import nl.vanbijleveld.dev.recipemanager.enums.ActionEnum;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "instruction")
public class Instruction {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "step", nullable = false)
    private Integer step;

    @Enumerated(EnumType.STRING)
    @Column(name = "action")
    private ActionEnum action;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "instruction", referencedColumnName = "id", nullable = false)
    private List<Ingredient> ingredients;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "appliance")
    private String appliance;

}
