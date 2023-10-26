package devflix.controllers;

import devflix.domain.MovieLanguageService;
import devflix.models.MovieLanguage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movie")
public class MovieLanguageController {
    private final MovieLanguageService movieLanguageService;
    public MovieLanguageController(MovieLanguageService movieLanguageService) {
        this.movieLanguageService = movieLanguageService;
    }

    @GetMapping("/{movieID}/language")
    public List<MovieLanguage> findMovieLanguage(@PathVariable int movieID) {return movieLanguageService.findMovieLanguage(movieID);}
}
