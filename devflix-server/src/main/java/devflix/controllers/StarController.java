package devflix.controllers;

import devflix.domain.DirectorService;
import devflix.domain.StarService;
import devflix.models.Director;
import devflix.models.Star;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movie")
public class StarController {
    private final StarService starService;
    public StarController(StarService starService) {
        this.starService = starService;
    }

    @GetMapping("/{movieID}/star")
    public List<Star> findMovieStar(@PathVariable int movieID) {return starService.findMovieStar(movieID);}
}
