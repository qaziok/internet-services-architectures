package pl.edu.pg.qaziok.laboratory_app.movie.dto.director;

import lombok.*;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Director;

import java.time.LocalDate;
import java.util.function.BiFunction;
import java.util.function.Function;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdateDirectorRequest {
    private String name;
    private LocalDate birthDate;

    public static BiFunction<Director, UpdateDirectorRequest, Director> dtoToEntityUpdater() {
        return (director, request) -> {
            director.setName(request.getName());
            director.setBirthDate(request.getBirthDate());
            return director;
        };
    }
}
