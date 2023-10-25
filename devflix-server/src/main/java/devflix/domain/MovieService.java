package devflix.domain;

import devflix.data.repositories.MovieRepository;
import devflix.models.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findByID(int movieID) {return movieRepository.findByID(movieID);}
}
