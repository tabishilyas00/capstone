package devflix.domain;

import devflix.data.repositories.MovieLanguageRepository;
import devflix.models.MovieLanguage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieLanguageService {
    private final MovieLanguageRepository movieLanguageRepository;
    public MovieLanguageService(MovieLanguageRepository movieLanguageRepository) {
        this.movieLanguageRepository = movieLanguageRepository;
    }

    public List<MovieLanguage> findMovieLanguage(int movieID) {return movieLanguageRepository.findMovieLanguage(movieID);}
}
