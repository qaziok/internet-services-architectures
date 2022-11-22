package pl.edu.pg.qaziok.movies.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.edu.pg.qaziok.movies.director.entity.Director;
import pl.edu.pg.qaziok.movies.director.service.DirectorService;
import pl.edu.pg.qaziok.movies.movie.dto.CreateMovieRequest;
import pl.edu.pg.qaziok.movies.movie.dto.GetMovieResponse;
import pl.edu.pg.qaziok.movies.movie.dto.GetMoviesResponse;
import pl.edu.pg.qaziok.movies.movie.dto.UpdateMovieRequest;
import pl.edu.pg.qaziok.movies.movie.entity.Movie;
import pl.edu.pg.qaziok.movies.movie.service.MovieService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/directors/{directorId}/movies")
public class DirectorMovieController {
    private final MovieService movieService;
    private final DirectorService directorService;
    
    @Autowired
    public DirectorMovieController(MovieService movieService, DirectorService directorService) {
        this.movieService = movieService;
        this.directorService = directorService;
    }
    
    @GetMapping
    public ResponseEntity<GetMoviesResponse> getMovies(@PathVariable("directorId") Long id){
        Optional<Director> director = directorService.find(id);
        if(director.isPresent()){
            List<Movie> movies = movieService.findAll(director.get());
            return ResponseEntity.ok(GetMoviesResponse.entityToDtoMapper().apply(movies));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping({"{movieId}"})
    public ResponseEntity<GetMovieResponse> getMovie(@PathVariable("directorId") Long directorId, @PathVariable("movieId") Long movieId){
        return movieService.find(directorId, movieId)
                .map(movie -> ResponseEntity.ok(GetMovieResponse.entityToDtoMapper().apply(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createMovie(@PathVariable("directorId") Long directorId, @RequestBody CreateMovieRequest request, UriComponentsBuilder builder){
        Optional<Director> director = directorService.find(directorId);
        if(director.isPresent()){
            Movie createdMovie = CreateMovieRequest.dtoToEntityMapper(id -> director.get()).apply(request);
            movieService.create(createdMovie);

            return ResponseEntity.created(builder.pathSegment("api", "directors", "{directorId}", "movies", "{movieId}")
                    .buildAndExpand(director.get().getId(), createdMovie.getId()).toUri()).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping({"{movieId}"})
    public ResponseEntity<Void> deleteMovie(@PathVariable("directorId") Long directorId, @RequestBody UpdateMovieRequest request, @PathVariable("movieId") Long movieId){
        Optional<Movie> movie = movieService.find(directorId, movieId);
        if(movie.isPresent()){
            UpdateMovieRequest.dtoToEntityUpdater().apply(movie.get(), request);
            movieService.delete(movie.get().getId());
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping({"{movieId}"})
    public ResponseEntity<Void> updateMovie(@PathVariable("directorId") Long directorId, @RequestBody UpdateMovieRequest request, @PathVariable("movieId") Long movieId){
        Optional<Movie> movie = movieService.find(directorId, movieId);
        if(movie.isPresent()){
            UpdateMovieRequest.dtoToEntityUpdater().apply(movie.get(), request);
            movieService.update(movie.get());
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
