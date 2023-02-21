package chapter06;

import jakarta.annotation.Resource;
import jakarta.persistence.*;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Date;
import java.util.List;

@Data
@Entity
@RestResource(rel = "tacos", path = "tacos")
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;
    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<String> ingredients;
    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }
}
