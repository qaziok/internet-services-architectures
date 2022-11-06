package pl.edu.pg.qaziok.laboratory_app.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.edu.pg.qaziok.laboratory_app.movie.dto.movie.*;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Movie;
import pl.edu.pg.qaziok.laboratory_app.movie.service.DirectorService;
import pl.edu.pg.qaziok.laboratory_app.movie.service.MovieService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping("api/movies")
public class MovieController {
    private final MovieService movieService;
    private final DirectorService directorService;

    @Autowired
    public MovieController(MovieService movieService, DirectorService directorService) {
        this.movieService = movieService;
        this.directorService = directorService;
    }

    @GetMapping
    public ResponseEntity<GetMoviesResponse> getMovies(){
        List<Movie> all = movieService.findAll();
        Function<Collection<Movie>, GetMoviesResponse> mapper = GetMoviesResponse.entityToDtoMapper();
        GetMoviesResponse response = mapper.apply(all);
        return ResponseEntity.ok(response);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<GetMovieResponse> getMovie(@PathVariable("id") Long id){
        return movieService.find(id)
                .map(movie -> ResponseEntity.ok(GetMovieResponse.entityToDtoMapper().apply(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createMovie(@RequestBody CreateMovieRequest request, UriComponentsBuilder builder){
        Movie movie = CreateMovieRequest
                .dtoToEntityMapper(id -> directorService.find(id).orElseThrow())
                .apply(request);
        movie = movieService.create(movie);
        return ResponseEntity.created(builder.pathSegment("api", "movies", "{id}")
                .buildAndExpand(movie.getId()).toUri()).build();
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") Long id){
        Optional<Movie> movie = movieService.find(id);
        if(movie.isPresent()){
            movieService.delete(movie.get().getId());
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping({"{id}"})
    public ResponseEntity<Void> updateMovie(@PathVariable("id") Long id, @RequestBody UpdateMovieRequest request){
        Optional<Movie> movie = movieService.find(id);
        if(movie.isPresent()){
            UpdateMovieRequest.dtoToEntityUpdater().apply(movie.get(), request);
            movieService.update(movie.get());
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
