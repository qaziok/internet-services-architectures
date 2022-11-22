package pl.edu.pg.qaziok.movies.movie.dto;


import lombok.*;
import pl.edu.pg.qaziok.movies.director.entity.Director;
import pl.edu.pg.qaziok.movies.movie.entity.Movie;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Supplier;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CreateMovieRequest {
    private String title;
    private String genre;
    private Long director;
    private LocalDate releaseDate;

    public static Function<CreateMovieRequest, Movie> dtoToEntityMapper(
            Function<Long,Director> directorFinder
    ) {
        return request -> Movie.builder()
                .title(request.getTitle())
                .genre(request.getGenre())
                .releaseDate(request.getReleaseDate())
                .director(directorFinder.apply(request.getDirector()))
                .build();
    }
}
