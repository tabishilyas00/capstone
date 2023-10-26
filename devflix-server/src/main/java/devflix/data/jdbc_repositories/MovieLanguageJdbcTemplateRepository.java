package devflix.data.jdbc_repositories;

import devflix.data.mappers.MovieLanguageMapper;
import devflix.data.repositories.MovieLanguageRepository;
import devflix.models.MovieLanguage;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieLanguageJdbcTemplateRepository implements MovieLanguageRepository {
    private final JdbcTemplate jdbcTemplate;
    public MovieLanguageJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MovieLanguage> findMovieLanguage(int movieID) {
        final String sql = """
                select
                    ml.movie_id , ml.language_id ,
                    l.name
                from movie_language ml
                inner join lang l on ml.language_id = l.language_id
                where ml.movie_id = ?
                """;

        return jdbcTemplate.query(sql , new MovieLanguageMapper() , movieID);
    }
}
