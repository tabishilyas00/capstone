package devflix.data.repositories;

import devflix.models.Writer;

import java.util.List;

public interface WriterRepository {
    List<Writer> findMovieWriter(int movieID);
}
