package devflix.data.repositories;

import devflix.models.Movie;
import devflix.models.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MovieRepository {
    List<Movie> findAll();

    @Transactional
    Movie findByTitle(String title);

    @Transactional
    Movie findByYear(String year);

    @Transactional
    Movie findByRating(String rating);

    @Transactional
    Movie findByDirector(Person director);

    @Transactional
    Movie findByWriter(Person writer);

    @Transactional
    Movie findByStar(Person star);

    Movie add(Movie movie);

    boolean update(Movie movie);

    @Transactional
    boolean deleteByID(int movieID);
}
