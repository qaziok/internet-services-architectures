package pl.edu.pg.qaziok.laboratory_app.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Director;
import pl.edu.pg.qaziok.laboratory_app.movie.repository.DirectorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    private final DirectorRepository repository;

    @Autowired
    public DirectorService(DirectorRepository repository){
        this.repository = repository;
    }

    public Optional<Director> find(String id){
        return repository.find(id);
    }

    public List<Director> findAll(){
        return repository.findAll();
    }

    public void create(Director director){
        repository.create(director);
    }

    public void delete(Director director){
        repository.delete(director);
    }
}
