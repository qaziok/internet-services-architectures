package pl.edu.pg.qaziok.laboratory_app.movie.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pg.qaziok.laboratory_app.data_storage.DataStorage;
import pl.edu.pg.qaziok.laboratory_app.movie.entity.Director;
import pl.edu.pg.qaziok.laboratory_app.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface DirectorRepository extends JpaRepository<Director,Long> {}
