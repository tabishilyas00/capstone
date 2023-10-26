package devflix.domain;

import devflix.data.repositories.StarRepository;
import devflix.models.Star;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarService {
    private final StarRepository starRepository;
    public StarService(StarRepository starRepository) {
        this.starRepository = starRepository;
    }

    public List<Star> findMovieStar(int movieID) {return starRepository.findMovieStar(movieID);}
}
