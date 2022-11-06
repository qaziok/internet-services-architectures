package pl.edu.pg.qaziok.laboratory_app.movie.dto.movie;


import lombok.*;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Director;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Movie;

import java.time.LocalDate;
import java.util.function.Function;

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
            Function<Long, Director> directorFunction
    ) {
        return request -> Movie.builder()
                .title(request.getTitle())
                .genre(request.getGenre())
                .releaseDate(request.getReleaseDate())
                .director(directorFunction.apply(request.getDirector()))
                .build();
    }
}
