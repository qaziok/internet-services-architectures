package pl.edu.pg.qaziok.movies.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.qaziok.movies.director.entity.Director;
import pl.edu.pg.qaziok.movies.movie.entity.Movie;
import pl.edu.pg.qaziok.movies.director.service.DirectorService;
import pl.edu.pg.qaziok.movies.movie.service.MovieService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Init {
    private final DirectorService directorService;
    private final MovieService movieService;

    @Autowired
    public Init(DirectorService directorService, MovieService movieService) {
        this.directorService = directorService;
        this.movieService = movieService;
    }

    @PostConstruct
    public synchronized void init(){

        Map<Director, List<Movie>> movies = new HashMap<>();

        // Steven Spielberg LocalDate.of(1946, 12, 18)
        movies.put(Director.builder().id(1L).build(), List.of(
                Movie.builder().title("Jaws").genre("Horror").releaseDate(LocalDate.of(1975, 6, 20)).build(),
                Movie.builder().title("Indiana Jones and the Last Crusade").genre("Adventure").releaseDate(LocalDate.of(1989, 5, 24)).build(),
                Movie.builder().title("Jurassic Park").genre("Adventure").releaseDate(LocalDate.of(1993, 6, 11)).build(),
                Movie.builder().title("Schindler's List").genre("Drama").releaseDate(LocalDate.of(1993, 2, 4)).build(),
                Movie.builder().title("Saving Private Ryan").genre("War").releaseDate(LocalDate.of(1998, 7, 24)).build(),
                Movie.builder().title("Catch Me If You Can").genre("Biography").releaseDate(LocalDate.of(2002, 12, 25)).build(),
                Movie.builder().title("The Terminal").genre("Comedy").releaseDate(LocalDate.of(2004, 6, 18)).build(),
                Movie.builder().title("War Horse").genre("Drama").releaseDate(LocalDate.of(2011, 12, 25)).build(),
                Movie.builder().title("Lincoln").genre("Biography").releaseDate(LocalDate.of(2012, 11, 9)).build(),
                Movie.builder().title("Bridge of Spies").genre("Drama").releaseDate(LocalDate.of(2015, 10, 16)).build(),
                Movie.builder().title("Ready Player One").genre("Adventure").releaseDate(LocalDate.of(2018, 3, 29)).build(),
                Movie.builder().title("The Post").genre("Drama").releaseDate(LocalDate.of(2017, 12, 22)).build(),
                Movie.builder().title("The BFG").genre("Adventure").releaseDate(LocalDate.of(2016, 7, 1)).build(),
                Movie.builder().title("The Adventures of Tintin").genre("Adventure").releaseDate(LocalDate.of(2011, 10, 26)).build(),
                Movie.builder().title("The Color Purple").genre("Drama").releaseDate(LocalDate.of(1985, 12, 18)).build()
        ));

        // Stanley Kubrick LocalDate.of(1928, 7, 26)
        movies.put(Director.builder().id(2L).build(), List.of(
                Movie.builder().title("2001: A Space Odyssey").genre("Sci-Fi").releaseDate(LocalDate.of(1968, 4, 6)).build(),
                Movie.builder().title("A Clockwork Orange").genre("Crime").releaseDate(LocalDate.of(1971, 12, 19)).build(),
                Movie.builder().title("The Shining").genre("Horror").releaseDate(LocalDate.of(1980, 5, 23)).build(),
                Movie.builder().title("Full Metal Jacket").genre("War").releaseDate(LocalDate.of(1987, 7, 24)).build(),
                Movie.builder().title("Eyes Wide Shut").genre("Drama").releaseDate(LocalDate.of(1999, 7, 16)).build(),
                Movie.builder().title("The Shining").genre("Horror").releaseDate(LocalDate.of(1980, 5, 23)).build(),
                Movie.builder().title("Dr. Strangelove or: How I Learned to Stop Worrying and Love the Bomb").genre("Comedy").releaseDate(LocalDate.of(1964, 1, 29)).build(),
                Movie.builder().title("Barry Lyndon").genre("Drama").releaseDate(LocalDate.of(1975, 12, 18)).build(),
                Movie.builder().title("Lolita").genre("Drama").releaseDate(LocalDate.of(1962, 6, 13)).build(),
                Movie.builder().title("Paths of Glory").genre("War").releaseDate(LocalDate.of(1957, 10, 5)).build(),
                Movie.builder().title("Spartacus").genre("Drama").releaseDate(LocalDate.of(1960, 12, 17)).build(),
                Movie.builder().title("The Killing").genre("Crime").releaseDate(LocalDate.of(1956, 4, 21)).build()
        ));

        // Martin Scorsese LocalDate.of(1942, 11, 17)
        movies.put(Director.builder().id(3L).build(), List.of(
                Movie.builder().title("The Departed").genre("Crime").releaseDate(LocalDate.of(2006, 10, 6)).build(),
                Movie.builder().title("The Wolf of Wall Street").genre("Biography").releaseDate(LocalDate.of(2013, 12, 25)).build(),
                Movie.builder().title("The Aviator").genre("Biography").releaseDate(LocalDate.of(2004, 12, 25)).build(),
                Movie.builder().title("Shutter Island").genre("Mystery").releaseDate(LocalDate.of(2010, 2, 19)).build(),
                Movie.builder().title("Goodfellas").genre("Crime").releaseDate(LocalDate.of(1990, 9, 21)).build(),
                Movie.builder().title("Casino").genre("Crime").releaseDate(LocalDate.of(1995, 11, 22)).build(),
                Movie.builder().title("Taxi Driver").genre("Crime").releaseDate(LocalDate.of(1976, 2, 8)).build(),
                Movie.builder().title("Raging Bull").genre("Biography").releaseDate(LocalDate.of(1980, 12, 19)).build(),
                Movie.builder().title("The Last Temptation of Christ").genre("Drama").releaseDate(LocalDate.of(1988, 12, 25)).build(),
                Movie.builder().title("The Age of Innocence").genre("Drama").releaseDate(LocalDate.of(1993, 12, 25)).build(),
                Movie.builder().title("The Color of Money").genre("Drama").releaseDate(LocalDate.of(1986, 12, 25)).build(),
                Movie.builder().title("The King of Comedy").genre("Comedy").releaseDate(LocalDate.of(1983, 12, 25)).build(),
                Movie.builder().title("New York, New York").genre("Drama").releaseDate(LocalDate.of(1977, 12, 25)).build(),
                Movie.builder().title("Mean Streets").genre("Crime").releaseDate(LocalDate.of(1973, 12, 25)).build(),
                Movie.builder().title("Alice Doesn't Live Here Anymore").genre("Drama").releaseDate(LocalDate.of(1974, 12, 25)).build()
        ));

        // Christopher Nolan LocalDate.of(1970, 7, 30)
        movies.put(Director.builder().id(4L).build(), List.of(
                Movie.builder().title("The Dark Knight").genre("Action").releaseDate(LocalDate.of(2008, 7, 18)).build(),
                Movie.builder().title("Inception").genre("Action").releaseDate(LocalDate.of(2010, 7, 16)).build(),
                Movie.builder().title("Interstellar").genre("Sci-Fi").releaseDate(LocalDate.of(2014, 11, 7)).build(),
                Movie.builder().title("Dunkirk").genre("War").releaseDate(LocalDate.of(2017, 7, 21)).build(),
                Movie.builder().title("The Prestige").genre("Mystery").releaseDate(LocalDate.of(2006, 10, 20)).build(),
                Movie.builder().title("Batman Begins").genre("Action").releaseDate(LocalDate.of(2005, 6, 15)).build(),
                Movie.builder().title("Insomnia").genre("Crime").releaseDate(LocalDate.of(2002, 6, 28)).build(),
                Movie.builder().title("Memento").genre("Mystery").releaseDate(LocalDate.of(2000, 10, 11)).build(),
                Movie.builder().title("Following").genre("Mystery").releaseDate(LocalDate.of(1998, 10, 30)).build(),
                Movie.builder().title("The Dark Knight Rises").genre("Action").releaseDate(LocalDate.of(2012, 7, 20)).build(),
                Movie.builder().title("The Prestige").genre("Mystery").releaseDate(LocalDate.of(2006, 10, 20)).build()
        ));

        // Quentin Tarantino LocalDate.of(1963, 3, 27)
        movies.put(Director.builder().id(5L).build(), List.of(
                Movie.builder().title("Pulp Fiction").genre("Crime").releaseDate(LocalDate.of(1994, 10, 14)).build(),
                Movie.builder().title("Inglourious Basterds").genre("War").releaseDate(LocalDate.of(2009, 8, 21)).build(),
                Movie.builder().title("Django Unchained").genre("Western").releaseDate(LocalDate.of(2012, 12, 25)).build(),
                Movie.builder().title("Kill Bill: Vol. 1").genre("Action").releaseDate(LocalDate.of(2003, 10, 10)).build(),
                Movie.builder().title("Kill Bill: Vol. 2").genre("Action").releaseDate(LocalDate.of(2004, 4, 16)).build(),
                Movie.builder().title("Reservoir Dogs").genre("Crime").releaseDate(LocalDate.of(1992, 10, 2)).build(),
                Movie.builder().title("Jackie Brown").genre("Crime").releaseDate(LocalDate.of(1997, 12, 25)).build(),
                Movie.builder().title("The Hateful Eight").genre("Western").releaseDate(LocalDate.of(2015, 12, 25)).build(),
                Movie.builder().title("Once Upon a Time in Hollywood").genre("Comedy").releaseDate(LocalDate.of(2019, 7, 26)).build(),
                Movie.builder().title("Death Proof").genre("Action").releaseDate(LocalDate.of(2007, 8, 22)).build(),
                Movie.builder().title("Grindhouse").genre("Action").releaseDate(LocalDate.of(2007, 4, 6)).build()
        ));

        // Alfred Hitchcock LocalDate.of(1899, 8, 13)
        movies.put(Director.builder().id(6L).build(), List.of(
                Movie.builder().title("Psycho").genre("Horror").releaseDate(LocalDate.of(1960, 9, 8)).build(),
                Movie.builder().title("Vertigo").genre("Mystery").releaseDate(LocalDate.of(1958, 8, 21)).build(),
                Movie.builder().title("Rear Window").genre("Mystery").releaseDate(LocalDate.of(1954, 9, 1)).build(),
                Movie.builder().title("North by Northwest").genre("Action").releaseDate(LocalDate.of(1959, 9, 26)).build(),
                Movie.builder().title("The Birds").genre("Horror").releaseDate(LocalDate.of(1963, 12, 16)).build(),
                Movie.builder().title("The 39 Steps").genre("Mystery").releaseDate(LocalDate.of(1935, 9, 2)).build(),
                Movie.builder().title("Notorious").genre("Romance").releaseDate(LocalDate.of(1946, 9, 1)).build()
        ));

        // James Cameron LocalDate.of(1954, 8, 16)
        movies.put(Director.builder().id(7L).build(), List.of(
                Movie.builder().title("Avatar").genre("Sci-Fi").releaseDate(LocalDate.of(2009, 12, 18)).build(),
                Movie.builder().title("Titanic").genre("Romance").releaseDate(LocalDate.of(1997, 12, 19)).build(),
                Movie.builder().title("Terminator 2: Judgment Day").genre("Action").releaseDate(LocalDate.of(1991, 7, 3)).build(),
                Movie.builder().title("The Abyss").genre("Sci-Fi").releaseDate(LocalDate.of(1989, 7, 14)).build(),
                Movie.builder().title("True Lies").genre("Action").releaseDate(LocalDate.of(1994, 7, 22)).build(),
                Movie.builder().title("Aliens").genre("Sci-Fi").releaseDate(LocalDate.of(1986, 7, 18)).build()
        ));

        // George Lucas LocalDate.of(1944, 5, 14)
        movies.put(Director.builder().id(8L).build(), List.of(
                Movie.builder().title("Star Wars: Episode IV - A New Hope").genre("Sci-Fi").releaseDate(LocalDate.of(1977, 5, 25)).build(),
                Movie.builder().title("Star Wars: Episode V - The Empire Strikes Back").genre("Sci-Fi").releaseDate(LocalDate.of(1980, 5, 21)).build(),
                Movie.builder().title("Star Wars: Episode VI - Return of the Jedi").genre("Sci-Fi").releaseDate(LocalDate.of(1983, 5, 25)).build(),
                Movie.builder().title("Star Wars: Episode I - The Phantom Menace").genre("Sci-Fi").releaseDate(LocalDate.of(1999, 5, 19)).build(),
                Movie.builder().title("Star Wars: Episode II - Attack of the Clones").genre("Sci-Fi").releaseDate(LocalDate.of(2002, 5, 16)).build(),
                Movie.builder().title("Star Wars: Episode III - Revenge of the Sith").genre("Sci-Fi").releaseDate(LocalDate.of(2005, 5, 19)).build()
        ));

        // David Fincher LocalDate.of(1962, 8, 28)
        movies.put(Director.builder().id(9L).build(), List.of(
                Movie.builder().title("Fight Club").genre("Drama").releaseDate(LocalDate.of(1999, 10, 15)).build(),
                Movie.builder().title("The Social Network").genre("Drama").releaseDate(LocalDate.of(2010, 10, 1)).build(),
                Movie.builder().title("Seven").genre("Crime").releaseDate(LocalDate.of(1995, 9, 22)).build(),
                Movie.builder().title("Zodiac").genre("Crime").releaseDate(LocalDate.of(2007, 3, 2)).build(),
                Movie.builder().title("The Curious Case of Benjamin Button").genre("Drama").releaseDate(LocalDate.of(2008, 12, 25)).build()
        ));

        // Tim Burton LocalDate.of(1958, 8, 25)
        movies.put(Director.builder().id(10L).build(), List.of(
                Movie.builder().title("Edward Scissorhands").genre("Fantasy").releaseDate(LocalDate.of(1990, 12, 7)).build(),
                Movie.builder().title("The Nightmare Before Christmas").genre("Fantasy").releaseDate(LocalDate.of(1993, 10, 29)).build(),
                Movie.builder().title("Beetlejuice").genre("Fantasy").releaseDate(LocalDate.of(1988, 3, 30)).build(),
                Movie.builder().title("Batman").genre("Action").releaseDate(LocalDate.of(1989, 6, 23)).build(),
                Movie.builder().title("Batman Returns").genre("Action").releaseDate(LocalDate.of(1992, 6, 19)).build(),
                Movie.builder().title("Batman Forever").genre("Action").releaseDate(LocalDate.of(1995, 5, 31)).build(),
                Movie.builder().title("Batman & Robin").genre("Action").releaseDate(LocalDate.of(1997, 6, 20)).build(),
                Movie.builder().title("Mars Attacks!").genre("Comedy").releaseDate(LocalDate.of(1996, 12, 12)).build(),
                Movie.builder().title("Charlie and the Chocolate Factory").genre("Fantasy").releaseDate(LocalDate.of(2005, 7, 15)).build(),
                Movie.builder().title("Alice in Wonderland").genre("Fantasy").releaseDate(LocalDate.of(2010, 3, 5)).build(),
                Movie.builder().title("Sweeney Todd: The Demon Barber of Fleet Street").genre("Musical").releaseDate(LocalDate.of(2007, 12, 21)).build(),
                Movie.builder().title("Big Fish").genre("Fantasy").releaseDate(LocalDate.of(2003, 12, 25)).build(),
                Movie.builder().title("Corpse Bride").genre("Fantasy").releaseDate(LocalDate.of(2005, 10, 19)).build(),
                Movie.builder().title("Frankenweenie").genre("Fantasy").releaseDate(LocalDate.of(2012, 10, 5)).build()
        ));

        // Edgar Wright LocalDate.of(1974, 4, 18)
        movies.put(Director.builder().id(11L).build(), List.of(
                Movie.builder().title("Shaun of the Dead").genre("Comedy").releaseDate(LocalDate.of(2004, 4, 9)).build(),
                Movie.builder().title("Hot Fuzz").genre("Comedy").releaseDate(LocalDate.of(2007, 4, 20)).build(),
                Movie.builder().title("Scott Pilgrim vs. the World").genre("Comedy").releaseDate(LocalDate.of(2010, 8, 13)).build(),
                Movie.builder().title("Baby Driver").genre("Action").releaseDate(LocalDate.of(2017, 6, 28)).build()
        ));

        for (Map.Entry<Director, List<Movie>> entry : movies.entrySet()) {
            Director director = entry.getKey();
            List<Movie> movieList = entry.getValue();
            directorService.create(director);
            movieList.forEach(movie -> {
                movie.setDirector(director);
                movieService.create(movie);
            });
        }

        directorService.findAll().forEach(System.out::println);
        movieService.findAll().forEach(System.out::println);
    }


}
