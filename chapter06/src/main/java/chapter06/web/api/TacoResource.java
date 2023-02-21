package chapter06.web.api;

import java.util.Date;
import java.util.List;

import chapter06.Ingredient;
import chapter06.Taco;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(value = "taco", collectionRelation = "tacos")
public class TacoResource extends RepresentationModel<TacoResource> {
    @Getter
    private final String name;

    @Getter
    private final Date createdAt;

    @Getter
    private final List<String> ingredients;

    public TacoResource(Taco taco){
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = taco.getIngredients();
    }

}
