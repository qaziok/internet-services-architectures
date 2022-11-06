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
public class CreateDirectorRequest {
    private String name;
    private LocalDate birthDate;

    public static Function<CreateDirectorRequest, Director> dtoToEntityMapper() {
        return request -> Director.builder()
                .name(request.getName())
                .birthDate(request.getBirthDate())
                .build();
    }
}
