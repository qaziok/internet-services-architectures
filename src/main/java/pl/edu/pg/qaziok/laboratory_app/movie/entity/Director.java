package pl.edu.pg.qaziok.laboratory_app.movie.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString()
@EqualsAndHashCode()
public class Director implements Serializable {
    private String name;
    private LocalDate birthYear;
}

