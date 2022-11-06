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
public class Movie implements Serializable {
    private String title;
    private Director director;
    private String genre;
    private LocalDate releaseDate;
}
