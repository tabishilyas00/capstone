package devflix.data.repositories;

import devflix.models.Director;

import java.util.List;

public interface DirectorRepository {
    List<Director> findMovieDirector(int movieID);
}
