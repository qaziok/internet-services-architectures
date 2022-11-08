package pl.edu.pg.qaziok.laboratory_app.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.edu.pg.qaziok.laboratory_app.movie.dto.director.*;
import pl.edu.pg.qaziok.laboratory_app.movie.dto.movie.GetMoviesByDirectorResponse;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Director;
import pl.edu.pg.qaziok.laboratory_app.movie.service.DirectorService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping("api/directors")
public class DirectorController {
    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public ResponseEntity<GetDirectorsResponse> getDirectors(){
        List<Director> all = directorService.findAll();
        Function<Collection<Director>, GetDirectorsResponse> mapper = GetDirectorsResponse.entityToDtoMapper();
        GetDirectorsResponse response = mapper.apply(all);
        return ResponseEntity.ok(response);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<GetDirectorResponse> getDirector(@PathVariable("id") Long id){
        return directorService.find(id)
                .map(director -> ResponseEntity.ok(GetDirectorResponse.entityToDtoMapper().apply(director)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping({"{id}/movies"})
    public ResponseEntity<GetMoviesByDirectorResponse> getMoviesByDirector(@PathVariable("id") Long id){
        return directorService.find(id)
                .map(director -> ResponseEntity.ok(GetMoviesByDirectorResponse.entityToDtoMapper().apply(director)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createDirector(@RequestBody CreateDirectorRequest request, UriComponentsBuilder builder){
        Director director = CreateDirectorRequest.dtoToEntityMapper().apply(request);
        director = directorService.create(director);
        return ResponseEntity.created(builder.pathSegment("api", "director", "{name}")
                .buildAndExpand(director.getName()).toUri()).build();
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

    @PutMapping({"{id}"})
    public ResponseEntity<Void> updateDirector(@PathVariable("id") Long id, @RequestBody UpdateDirectorRequest request){
        Optional<Director> director = directorService.find(id);
        if(director.isPresent()){
            UpdateDirectorRequest.dtoToEntityUpdater().apply(director.get(), request);
            directorService.update(director.get());
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.notFound().build();
    }
}
