package pl.edu.pg.qaziok.laboratory_app.movie.dto.movie;

import lombok.*;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Movie;

import java.time.LocalDate;
import java.util.function.BiFunction;

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
public class UpdateMovieRequest {
    private String title;
    private String genre;
    private LocalDate releaseDate;

    public static BiFunction<Movie, UpdateMovieRequest, Movie> dtoToEntityUpdater() {
        return (movie, request) -> {
            movie.setTitle(request.getTitle());
            movie.setGenre(request.getGenre());
            movie.setReleaseDate(request.getReleaseDate());
            return movie;
        };
    }

}
