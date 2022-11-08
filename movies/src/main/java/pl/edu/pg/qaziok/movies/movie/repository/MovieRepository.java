package pl.edu.pg.qaziok.movies.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pg.qaziok.movies.director.entity.Director;
import pl.edu.pg.qaziok.movies.movie.entity.Movie;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByDirector(Director director);

    Optional<Movie> findByDirectorAndId(Director director, Long id);
}
