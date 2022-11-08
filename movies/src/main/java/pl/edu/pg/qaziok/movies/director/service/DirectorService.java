package pl.edu.pg.qaziok.movies.director.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.qaziok.movies.director.entity.Director;
import pl.edu.pg.qaziok.movies.director.repository.DirectorRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    private final DirectorRepository repository;

    @Autowired
    public DirectorService(DirectorRepository repository){
        this.repository = repository;
    }

    public Optional<Director> find(Long id){
        return repository.findById(id);
    }

    public List<Director> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Director create(Director director){
        return repository.save(director);
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public void update(Director director){
        repository.save(director);
    }
}
