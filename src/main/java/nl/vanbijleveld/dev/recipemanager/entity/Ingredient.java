package nl.vanbijleveld.dev.recipemanager.entity;

import jakarta.persistence.*;
import lombok.*;
import nl.vanbijleveld.dev.recipemanager.enums.UnitEnum;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String ingredientName;

    @Column(name = "amount")
    private Integer amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit")
    private UnitEnum unit;

}
