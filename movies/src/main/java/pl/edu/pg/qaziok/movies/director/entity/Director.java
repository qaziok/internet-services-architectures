package pl.edu.pg.qaziok.movies.director.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import pl.edu.pg.qaziok.movies.movie.entity.Movie;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString()
@Entity
@Table(name = "directors")
public class Director implements Serializable {

    @Id
    private Long id;

    @OneToMany(mappedBy = "director", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Movie> directedMovies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Director director = (Director) o;
        return id != null && id.equals(director.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

