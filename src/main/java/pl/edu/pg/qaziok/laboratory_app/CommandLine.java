package pl.edu.pg.qaziok.laboratory_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Director;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Movie;
import pl.edu.pg.qaziok.laboratory_app.movie.service.DirectorService;
import pl.edu.pg.qaziok.laboratory_app.movie.service.MovieService;

import java.time.LocalDate;
import java.util.Scanner;

@Component
public class CommandLine implements CommandLineRunner {
    private final MovieService movieService;
    private final DirectorService directorService;

    public CommandLine(MovieService movieService, DirectorService directorService) {
        this.movieService = movieService;
        this.directorService = directorService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?");
        printMenu();
        while (true){
            chooseTask(scanner.nextInt());
            printMenu();
        }

    }

    private void chooseTask(int number){
        switch (number){
            case 1:
                System.out.println("You will create a movie");
                createMovie();
                break;
            case 2:
                System.out.println("You will create a director");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter director's name");
                createDirector(scanner.nextLine());
                break;
            case 3:
                System.out.println("You will delete a movie");
                deleteMovie();
                break;
            case 4:
                System.out.println("List of movies");
                movieService.findAll().forEach(System.out::println);
                break;
                case 5:
                System.out.println("List of directors");
                directorService.findAll().forEach(System.out::println);
                break;
            case 6:
                System.out.println("You will find a movie");
                findMovie();
                break;
            case 7:
                System.out.println("You will find a director");
                findDirector();
                break;
            case 8:
                System.out.println("You decided to exit");
                System.exit(0);
                break;
            default:
                System.out.println("Wrong number");
        }
    }

    private void findDirector() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter director's name");
        directorService.find(scanner.nextLine()).ifPresentOrElse(System.out::println, () -> System.out.println("Director not found"));
    }

    private void findMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter movie's title");
        String title = scanner.nextLine();
        movieService.find(title).ifPresentOrElse(System.out::println, () -> System.out.println("Movie not found"));
    }

    private void deleteMovie() {
        Scanner scanner = new Scanner(System.in);
        movieService.findAll().forEach(System.out::println);
        System.out.println("Choose movie to delete");
        String title = scanner.nextLine();

        movieService.find(title).ifPresentOrElse(movie -> {
            movieService.delete(movie);
            System.out.println("Movie deleted");
        }, () -> System.out.println("Movie not found"));
    }

    private void printMenu(){
        System.out.println("1. Create movie");
        System.out.println("2. Create director");
        System.out.println("3. Delete movie");
        System.out.println("4. List of movies");
        System.out.println("5. List of directors");
        System.out.println("6. Find movie");
        System.out.println("7. Find director");
        System.out.println("8. Exit");
    }

    private void createMovie(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter movie title: ");
        String title = scanner.nextLine();
        System.out.println("Enter movie genre: ");
        String genre = scanner.nextLine();
        System.out.println("Enter movie release date: ");
        LocalDate releaseDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Choose movie director: ");
        directorService.findAll().forEach(System.out::println);
        String name = scanner.nextLine();

        Director director = directorService.find(name).orElseGet(
                () -> {
                    System.out.println("Creating new director...");
                    return createDirector(name);
                }
        );

        Movie movie = Movie.builder()
                .title(title)
                .genre(genre)
                .releaseDate(releaseDate)
                .director(director)
                .build();

        movieService.create(movie);
        System.out.println("Movie created!");
    }

    private Director createDirector(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter director birth date: ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        Director director = Director.builder()
                .name(name)
                .birthYear(birthDate)
                .build();
        directorService.create(director);
        return director;
    }
}
