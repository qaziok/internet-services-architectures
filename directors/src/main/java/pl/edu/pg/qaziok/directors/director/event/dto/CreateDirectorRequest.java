package pl.edu.pg.qaziok.directors.director.event.dto;

import lombok.*;
import pl.edu.pg.qaziok.directors.director.entity.Director;

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

public static Function<Director, CreateDirectorRequest> entityToDtoMapper() {
        return director -> CreateDirectorRequest.builder()
                .id(director.getId())
                .build();
    }
}
