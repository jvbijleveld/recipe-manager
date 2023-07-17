package nl.vanbijleveld.dev.recipemanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recipe")
public class Recipe {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe", referencedColumnName = "id", nullable = false)
    private List<Instruction> instructions;

    @Column(name = "serves")
    private Integer serves;

}
