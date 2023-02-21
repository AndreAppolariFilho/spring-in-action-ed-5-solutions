package chapter06.web.api;

import chapter06.Taco;
import chapter06.data.TacoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RepositoryRestController
public class RecentTacosController {
    private TacoRepository tacoRepo;

    public RecentTacosController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    @GetMapping(path="/tacos/recent", produces = "application/hal+json")
    public ResponseEntity<CollectionModel<TacoResource>> recentTacos(){
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
        return new ResponseEntity<>(recentResources, HttpStatus.OK);
    }
}
