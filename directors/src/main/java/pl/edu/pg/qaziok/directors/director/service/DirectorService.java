package pl.edu.pg.qaziok.directors.director.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.qaziok.directors.director.entity.Director;
import pl.edu.pg.qaziok.directors.director.event.repository.DirectorEventRepository;
import pl.edu.pg.qaziok.directors.director.repository.DirectorRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    private final DirectorRepository repository;
    private final DirectorEventRepository eventRepository;

    @Autowired
    public DirectorService(DirectorRepository repository, DirectorEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    public Optional<Director> find(Long id){
        return repository.findById(id);
    }

    public List<Director> findAll(){
        return repository.findAll();
    }

    @Transactional
    public void create(Director director){
        repository.save(director);
        eventRepository.create(director);
    }

    @Transactional
    public void delete(Long id){
        eventRepository.delete(repository.getReferenceById(id));
        repository.deleteById(id);
    }

    @Transactional
    public void update(Director director){
        repository.save(director);
    }
}
