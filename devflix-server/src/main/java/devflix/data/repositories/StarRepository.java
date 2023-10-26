package devflix.data.repositories;

import devflix.models.Star;

import java.util.List;

public interface StarRepository {
    List<Star> findMovieStar(int movieID);
}
