package devflix.controllers;

import devflix.domain.DirectorService;
import devflix.models.Director;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movie")
public class DirectorController {
    private final DirectorService directorService;
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/{movieID}/director")
    public List<Director> findMovieDirector(@PathVariable int movieID) {return directorService.findMovieDirector(movieID);}
}
