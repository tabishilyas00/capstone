package devflix.domain;

import devflix.data.repositories.MovieCountryRepository;
import devflix.models.MovieCountry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCountryService {
    private final MovieCountryRepository movieCountryRepository;
    public MovieCountryService(MovieCountryRepository movieCountryRepository) {
        this.movieCountryRepository = movieCountryRepository;
    }

    public List<MovieCountry> findMovieCountry(int movieID) {return movieCountryRepository.findMovieCountry(movieID);}
}
