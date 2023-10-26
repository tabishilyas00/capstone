package devflix.domain;

import devflix.data.repositories.DirectorRepository;
import devflix.models.Director;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    private final DirectorRepository directorRepository;
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> findMovieDirector(int movieID) {return directorRepository.findMovieDirector(movieID);}
}
