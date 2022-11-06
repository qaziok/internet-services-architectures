package pl.edu.pg.qaziok.laboratory_app.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Movie;
import pl.edu.pg.qaziok.laboratory_app.movie.repository.MovieRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository movieRepository){
        this.repository = movieRepository;
    }

    public Optional<Movie> find(Long id){
        return repository.findById(id);
    }

    public List<Movie> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Movie create(Movie movie){
        return repository.save(movie);
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public void update(Movie movie){
        repository.save(movie);
    }


}
