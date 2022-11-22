package pl.edu.pg.qaziok.directors.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.qaziok.directors.director.entity.Director;
import pl.edu.pg.qaziok.directors.director.service.DirectorService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class Init {
    private final DirectorService directorService;

    @Autowired
    public Init(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PostConstruct
    public synchronized void init(){

        ArrayList<Director> directors = new ArrayList<>();

        // Steven Spielberg
        directors.add(Director.builder().name("Steven Spielberg").birthDate(LocalDate.of(1946, 12, 18)).build());

        // Stanley Kubrick
        directors.add(Director.builder().name("Stanley Kubrick").birthDate(LocalDate.of(1928,7,26)).build());

        // Martin Scorsese
        directors.add(Director.builder().name("Martin Scorsese").birthDate(LocalDate.of(1942,11,17)).build());

        // Christopher Nolan
        directors.add(Director.builder().name("Christopher Nolan").birthDate(LocalDate.of(1970,7,30)).build());

        // Quentin Tarantino
        directors.add(Director.builder().name("Quentin Tarantino").birthDate(LocalDate.of(1963,3,27)).build());

        // Alfred Hitchcock
        directors.add(Director.builder().name("Alfred Hitchcock").birthDate(LocalDate.of(1899,8,13)).build());

        // James Cameron
        directors.add(Director.builder().name("James Cameron").birthDate(LocalDate.of(1954,8,16)).build());

        // George Lucas
        directors.add(Director.builder().name("George Lucas").birthDate(LocalDate.of(1944,5,14)).build());

        // David Fincher
        directors.add(Director.builder().name("David Fincher").birthDate(LocalDate.of(1962,8,28)).build());

        // Tim Burton
        directors.add(Director.builder().name("Tim Burton").birthDate(LocalDate.of(1958,8,25)).build());

        // Edgar Wright
        directors.add(Director.builder().name("Edgar Wright").birthDate(LocalDate.of(1974,4,18)).build());

        for (Director director : directors) {
            directorService.create(director);
        }

        directorService.findAll().forEach(System.out::println);
    }


}
