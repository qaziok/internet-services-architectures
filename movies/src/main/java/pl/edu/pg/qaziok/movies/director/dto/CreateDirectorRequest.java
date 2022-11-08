package pl.edu.pg.qaziok.movies.director.dto;

import lombok.*;
import pl.edu.pg.qaziok.movies.director.entity.Director;

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
    private Long id;

    public static Function<CreateDirectorRequest, Director> dtoToEntityMapper() {
        return request -> Director.builder()
                .id(request.getId())
                .build();
    }
}
