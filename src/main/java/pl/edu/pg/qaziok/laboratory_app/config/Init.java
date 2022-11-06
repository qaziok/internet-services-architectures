package pl.edu.pg.qaziok.laboratory_app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Director;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Movie;
import pl.edu.pg.qaziok.laboratory_app.movie.service.DirectorService;
import pl.edu.pg.qaziok.laboratory_app.movie.service.MovieService;

import javax.annotation.PostConstruct;

@Component
public class Init {
    private final DirectorService directorService;
    private final MovieService movieService;

    @Autowired
    public Init(DirectorService directorService, MovieService movieService) {
        this.directorService = directorService;
        this.movieService = movieService;
    }

    @PostConstruct
    public synchronized void init(){

        Director director = Director.builder().name("Steven Spielberg").build();
        directorService.create(director);
        Director director1 = Director.builder().name("Stanley Kubrick").build();
        directorService.create(director1);
        Director director2 = Director.builder().name("Martin Scorsese").build();
        directorService.create(director2);
        Director director3 = Director.builder().name("Quentin Tarantino").build();
        directorService.create(director3);
        Director director4 = Director.builder().name("Christopher Nolan").build();
        directorService.create(director4);
        Director director5 = Director.builder().name("James Cameron").build();
        directorService.create(director5);
        Director director6 = Director.builder().name("David Fincher").build();
        directorService.create(director6);

        movieService.create(Movie.builder().title("The Shawshank Redemption").director(director).build());
        movieService.create(Movie.builder().title("The Godfather").director(director1).build());
        movieService.create(Movie.builder().title("The Godfather: Part II").director(director2).build());
        movieService.create(Movie.builder().title("The Dark Knight").director(director3).build());
        movieService.create(Movie.builder().title("The Dark Knight Rises").director(director4).build());
        movieService.create(Movie.builder().title("Thor: Ragnarok").director(director5).build());
        movieService.create(Movie.builder().title("The Avengers").director(director6).build());

        directorService.findAll().forEach(System.out::println);
        movieService.findAll().forEach(System.out::println);
    }


}
