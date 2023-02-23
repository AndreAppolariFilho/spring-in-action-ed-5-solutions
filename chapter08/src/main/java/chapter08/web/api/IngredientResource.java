package chapter08.web.api;

import chapter08.Ingredient;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

public class IngredientResource extends RepresentationModel<IngredientResource> {
    @Getter
    private String name;

    @Getter
    private Ingredient.Type type;

    public IngredientResource(Ingredient ingredient){
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }
}
