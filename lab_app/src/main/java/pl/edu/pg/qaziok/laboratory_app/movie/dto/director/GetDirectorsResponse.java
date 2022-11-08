package pl.edu.pg.qaziok.laboratory_app.movie.dto.director;

import lombok.*;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Director;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetDirectorsResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Director {
        private Long id;
        private String name;
        private LocalDate birthDate;
    }

    @Singular
    private List<Director> directors;

    public static Function<Collection<pl.edu.pg.qaziok.laboratory_app.movie.entity.Director>, GetDirectorsResponse> entityToDtoMapper() {
        return directors -> {
            GetDirectorsResponseBuilder response = GetDirectorsResponse.builder();
            directors.stream()
                    .map(director -> Director.builder()
                            .id(director.getId())
                            .name(director.getName())
                            .birthDate(director.getBirthDate())
                            .build())
                    .forEach(response::director);
            return response.build();
        };
    }
}
