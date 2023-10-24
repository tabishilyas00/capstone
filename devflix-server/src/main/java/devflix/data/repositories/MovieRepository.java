package devflix.data.repositories;

import devflix.models.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> findAll();
}
