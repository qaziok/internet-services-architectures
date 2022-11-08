package pl.edu.pg.qaziok.laboratory_app.movie.dto.director;

import lombok.*;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Director;

import java.time.LocalDate;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetDirectorResponse {

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
    }

    private Long id;
    private String name;
    private LocalDate birthDate;

    public static Function<Director, GetDirectorResponse> entityToDtoMapper() {
        return director -> GetDirectorResponse.builder()
                .id(director.getId())
                .name(director.getName())
                .birthDate(director.getBirthDate())
                .build();
    }
}
