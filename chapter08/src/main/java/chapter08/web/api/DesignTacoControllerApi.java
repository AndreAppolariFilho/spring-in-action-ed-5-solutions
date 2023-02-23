package chapter08.web.api;

import chapter08.Taco;
import chapter08.data.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(
        path="/design",
        produces="application/json")
@CrossOrigin(origins="*")
public class DesignTacoControllerApi {
    private TacoRepository tacoRepo;
    @Autowired
    EntityLinks entityLinks;

    public DesignTacoControllerApi(TacoRepository tacoRepo){
        this.tacoRepo = tacoRepo;
    }

    @GetMapping("/recents")
    public CollectionModel<TacoResource> recentTacos(){
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending()
        );
        List<Taco> tacos = tacoRepo.findAll(page).getContent();
        CollectionModel<TacoResource> recentResources = new TacoResourceAssembler().toCollectionModel(tacos);

        recentResources.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder
                                .methodOn(DesignTacoControllerApi.class).recentTacos()
                        )
                        .withRel("recents")
        );
        return recentResources;
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco){
        return tacoRepo.save(taco);
    }

}
