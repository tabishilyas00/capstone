package devflix.data.repositories;

import devflix.models.MovieCountry;

import java.util.List;

public interface MovieCountryRepository {
    List<MovieCountry> findMovieCountry(int movieID);
}
