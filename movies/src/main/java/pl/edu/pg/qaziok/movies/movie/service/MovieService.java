package pl.edu.pg.qaziok.movies.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.qaziok.movies.director.entity.Director;
import pl.edu.pg.qaziok.movies.director.repository.DirectorRepository;
import pl.edu.pg.qaziok.movies.movie.entity.Movie;
import pl.edu.pg.qaziok.movies.movie.repository.MovieRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, DirectorRepository directorRepository) {

        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
    }

    public Optional<Movie> find(Long id){
        return movieRepository.findById(id);
    }

    public Optional<Movie> find(Long directorId, Long movieId){
        Optional<Director> director = directorRepository.findById(directorId);
        if(director.isPresent()){
            return movieRepository.findByDirectorAndId(director.get(), movieId);
        } else {
            return Optional.empty();
        }
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public List<Movie> findAll(Director director){
        return movieRepository.findAllByDirector(director);
    }

    @Transactional
    public Movie create(Movie movie){
        return movieRepository.save(movie);
    }

    @Transactional
    public void delete(Long id){
        movieRepository.deleteById(id);
    }

    @Transactional
    public void update(Movie movie){
        movieRepository.save(movie);
    }


}
