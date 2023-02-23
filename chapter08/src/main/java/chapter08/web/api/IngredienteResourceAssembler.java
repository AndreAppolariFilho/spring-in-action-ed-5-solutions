package chapter08.web.api;

import chapter08.Ingredient;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class IngredienteResourceAssembler extends RepresentationModelAssemblerSupport<Ingredient, IngredientResource> {

    public IngredienteResourceAssembler(Class<?> controllerClass, Class<IngredientResource> resourceType) {
        super(controllerClass, resourceType);
    }

    @Override
    public IngredientResource toModel(Ingredient entity) {
        return createModelWithId(entity.getId(), entity);
    }
}
