package devflix.data.repositories;

import devflix.models.MovieLanguage;

import java.util.List;

public interface MovieLanguageRepository {
    List<MovieLanguage> findMovieLanguage(int movieID);
}
