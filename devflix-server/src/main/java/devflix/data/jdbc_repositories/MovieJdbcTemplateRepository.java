package devflix.data.jdbc_repositories;

import devflix.data.mappers.MovieMapper;
import devflix.data.repositories.MovieRepository;
import devflix.models.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieJdbcTemplateRepository implements MovieRepository {
    private final JdbcTemplate jdbcTemplate;
    public MovieJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> findAll() {
        final String sql = """
                select
                    movie_id , title , year , rating , run_time , poster
                from movie;
                """;

        return jdbcTemplate.query(sql , new MovieMapper());
    }
}
