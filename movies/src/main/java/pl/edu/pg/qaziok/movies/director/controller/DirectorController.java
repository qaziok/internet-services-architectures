package pl.edu.pg.qaziok.movies.director.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.edu.pg.qaziok.movies.director.dto.CreateDirectorRequest;
import pl.edu.pg.qaziok.movies.director.entity.Director;
import pl.edu.pg.qaziok.movies.director.service.DirectorService;

import java.util.Optional;


@RestController
@RequestMapping("api/directors")
public class DirectorController {
    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PostMapping("")
    public ResponseEntity<Void> createDirector(@RequestBody CreateDirectorRequest request, UriComponentsBuilder builder){
        Director director = CreateDirectorRequest.dtoToEntityMapper().apply(request);
        directorService.create(director);
        return ResponseEntity.created(builder.pathSegment("api", "director", "{name}")
                .buildAndExpand(director.getId()).toUri()).build();
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<Void> deleteDirector(@PathVariable("id") Long id){
        Optional<Director> director = directorService.find(id);
        if(director.isPresent()){
            directorService.delete(director.get().getId());
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.notFound().build();
    }

}
