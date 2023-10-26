package devflix.controllers;

import devflix.domain.MovieCountryService;
import devflix.models.MovieCountry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movie")
public class MovieCountryController {
    private final MovieCountryService movieCountryService;
    public MovieCountryController(MovieCountryService movieCountryService) {
        this.movieCountryService = movieCountryService;
    }

    @GetMapping("/{movieID}/country")
    public List<MovieCountry> findMovieCountry(@PathVariable int movieID) {return movieCountryService.findMovieCountry(movieID);}
}
