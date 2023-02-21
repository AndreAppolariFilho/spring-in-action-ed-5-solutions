package chapter06.web.api;

import chapter06.Taco;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class TacoResourceAssembler extends RepresentationModelAssemblerSupport<Taco, TacoResource> {
    public TacoResourceAssembler(){
        super(DesignTacoControllerApi.class, TacoResource.class);
    }
    @Override
    public TacoResource instantiateModel(Taco entity){
        return new TacoResource(entity);
    }
    @Override
    public TacoResource toModel(Taco entity) {

        return createModelWithId(entity.getId(), entity);
    }
}
