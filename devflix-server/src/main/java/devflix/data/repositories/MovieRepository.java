package devflix.data.repositories;

import devflix.models.Movie;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MovieRepository {
    List<Movie> findAll();

    @Transactional
    Movie findByID(int movieID);
}
