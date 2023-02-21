package chapter06.web.api;

import chapter06.Ingredient;
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
