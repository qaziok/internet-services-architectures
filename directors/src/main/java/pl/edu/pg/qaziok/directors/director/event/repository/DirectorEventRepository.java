package pl.edu.pg.qaziok.directors.director.event.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.edu.pg.qaziok.directors.director.event.dto.CreateDirectorRequest;
import pl.edu.pg.qaziok.directors.director.entity.Director;

@Repository
public class DirectorEventRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public DirectorEventRepository(@Value("${movie.movies.url}") String baseUrl) {
        this.restTemplate = new RestTemplateBuilder().rootUri(baseUrl).build();
    }

    public void delete(Director director) {
        restTemplate.delete("/directors/{id}", director.getId());
    }

    public void create(Director director) {
        restTemplate.postForLocation("/directors", CreateDirectorRequest.entityToDtoMapper().apply(director));
    }

}
