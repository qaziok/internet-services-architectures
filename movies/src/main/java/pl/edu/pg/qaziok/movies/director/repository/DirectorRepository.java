package pl.edu.pg.qaziok.movies.director.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pg.qaziok.movies.director.entity.Director;

@org.springframework.stereotype.Repository
public interface DirectorRepository extends JpaRepository<Director,Long> {}
