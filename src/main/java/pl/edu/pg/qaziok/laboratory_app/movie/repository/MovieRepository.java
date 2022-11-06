package pl.edu.pg.qaziok.laboratory_app.movie.repository;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.pg.qaziok.laboratory_app.data_storage.DataStorage;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Movie;
import pl.edu.pg.qaziok.laboratory_app.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class MovieRepository implements Repository<Movie, String> {
    private final DataStorage dataStorage;

    @Autowired
    public MovieRepository(DataStorage dataStorage){
        this.dataStorage = dataStorage;
    }

    @Override
    public Optional<Movie> find(String id) {
        return dataStorage.findMovie(id);
    }

    @Override
    public List<Movie> findAll() {
        return dataStorage.findAllMovies();
    }

    @Override
    public void create(Movie entity) {
        dataStorage.createMovie(entity);
    }

    @Override
    public void delete(Movie entity) {
        dataStorage.deleteMovie(entity);
    }
}
