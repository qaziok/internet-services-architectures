package pl.edu.pg.qaziok.laboratory_app.data_storage;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import pl.edu.pg.qaziok.laboratory_app.cloning.Cloning;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Director;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Movie;

import java.util.*;

@Log
@Component
public class DataStorage {
    private final Set<Movie> movies = new HashSet<>();
    private final Set<Director> directors = new HashSet<>();

    public synchronized List<Movie> findAllMovies() {
        return new ArrayList<>(movies);
    }

    public synchronized Optional<Movie> findMovie(String title) {
        return movies.stream()
                .filter(movie -> movie.getTitle().equals(title))
                .findFirst()
                .map(Cloning::clone);
    }

    public synchronized void createMovie(Movie movie) throws IllegalArgumentException {
        findMovie(movie.getTitle()).ifPresentOrElse(
                original -> {
                    throw new IllegalArgumentException(
                            String.format("The movie title \"%s\" is not unique", movie.getTitle()));
                },
                () -> movies.add(Cloning.clone(movie)));
    }

    public synchronized void deleteMovie(Movie movie) throws IllegalArgumentException {
        findMovie(movie.getTitle()).ifPresentOrElse(
                movies::remove,
                () -> {
                    throw new IllegalArgumentException(
                            String.format("The movie title \"%s\" not found", movie)
                    );
                }
        );
    }

    public synchronized List<Director> findAllDirectors() {
        return new ArrayList<>(directors);
    }

    public synchronized Optional<Director> findDirector(String name) {
        return directors.stream()
                .filter(director -> director.getName().equals(name))
                .findFirst()
                .map(Cloning::clone);
    }

    public synchronized void createDirector(Director director) throws IllegalArgumentException {
        findDirector(director.getName()).ifPresentOrElse(
                original -> {
                    throw new IllegalArgumentException(
                            String.format("The director name \"%s\" is not unique", director.getName()));
                },
                () -> directors.add(Cloning.clone(director)));
    }

    public synchronized void deleteDirector(Director director) throws IllegalArgumentException {
        findDirector(director.getName()).ifPresentOrElse(
                directors::remove,
                () -> {
                    throw new IllegalArgumentException(
                            String.format("The director name \"%s\" not found", director)
                    );
                }
        );
    }
}
