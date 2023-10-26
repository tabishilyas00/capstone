package devflix.controllers;

import devflix.domain.WriterService;
import devflix.models.Writer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movie")
public class WriterController {
    private final WriterService writerService;
    public WriterController(WriterService writerService) {
        this.writerService = writerService;
    }

    @GetMapping("/{movieID}/writer")
    public List<Writer> findMovieWriter(@PathVariable int movieID) {return writerService.findMovieWriter(movieID);}
}
