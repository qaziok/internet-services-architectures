package pl.edu.pg.qaziok.laboratory_app.movie.dto.movie;

import lombok.*;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Director;

import java.util.List;
import java.util.function.Function;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetMoviesByDirectorResponse {
    @Singular
    List<GetMoviesResponse.Movie> movies;

    public static Function<Director, GetMoviesByDirectorResponse> entityToDtoMapper() {
        return director -> {
            GetMoviesByDirectorResponseBuilder response = GetMoviesByDirectorResponse.builder();
            director.getDirectedMovies().stream()
                    .map(movie -> GetMoviesResponse.Movie.builder()
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
