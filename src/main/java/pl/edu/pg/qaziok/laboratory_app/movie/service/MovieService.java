package pl.edu.pg.qaziok.laboratory_app.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Movie;
import pl.edu.pg.qaziok.laboratory_app.movie.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository movieRepository){
        this.repository = movieRepository;
    }

    public Optional<Movie> find(String title){
        return repository.find(title);
    }

    public List<Movie> findAll(){
        return repository.findAll();
    }

    public void create(Movie movie){
        repository.create(movie);
    }

    public void delete(Movie movie){
        repository.delete(movie);
    }


}
