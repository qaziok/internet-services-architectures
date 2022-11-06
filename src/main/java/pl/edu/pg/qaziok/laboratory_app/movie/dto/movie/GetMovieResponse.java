package pl.edu.pg.qaziok.laboratory_app.movie.dto.movie;

import lombok.*;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Movie;

import java.time.LocalDate;
import java.util.function.Function;

/**
 * A DTO for the {@link pl.edu.pg.qaziok.laboratory_app.movie.entity.Movie } entity.
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetMovieResponse {
    private Long id;
    private String title;
    private String genre;
    private String director;
    private LocalDate releaseDate;

    public static Function<Movie, GetMovieResponse> entityToDtoMapper() {
        return movie -> GetMovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .director(movie.getDirector().getName())
                .releaseDate(movie.getReleaseDate())
                .build();
    }
}
