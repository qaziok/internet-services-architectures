package pl.edu.pg.qaziok.laboratory_app.movie.repository;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.pg.qaziok.laboratory_app.data_storage.DataStorage;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Director;
import pl.edu.pg.qaziok.laboratory_app.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class DirectorRepository implements Repository<Director,String> {
    private final DataStorage dataStorage;

    @Autowired
    public DirectorRepository(DataStorage dataStorage){
        this.dataStorage = dataStorage;
    }

    @Override
    public Optional<Director> find(String id) {
        return dataStorage.findDirector(id);
    }

    @Override
    public List<Director> findAll() {
        return dataStorage.findAllDirectors();
    }

    @Override
    public void create(Director entity) {
        dataStorage.createDirector(entity);
    }

    @Override
    public void delete(Director entity) {
        dataStorage.deleteDirector(entity);
    }
}
