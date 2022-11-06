package pl.edu.pg.qaziok.laboratory_app.movie.dto.movie;

import lombok.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
 * A DTO for the {@link pl.edu.pg.qaziok.laboratory_app.movie.entity.Movie} entity.
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetMoviesResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Movie {
        private Long id;
        private String title;
        private String genre;
        private LocalDate releaseDate;
    }

    @Singular
    private List<Movie> movies;

    public static Function<Collection<pl.edu.pg.qaziok.laboratory_app.movie.entity.Movie>, GetMoviesResponse> entityToDtoMapper() {
        return movies -> {
            GetMoviesResponseBuilder response = GetMoviesResponse.builder();
            movies.stream()
                    .map(movie -> Movie.builder()
                            .id(movie.getId())
                            .title(movie.getTitle())
                            .genre(movie.getGenre())
                            .releaseDate(movie.getReleaseDate())
                            .build())
                    .forEach(response::movie);
            return response.build();
        };
    }
}
