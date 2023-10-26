package devflix.data.jdbc_repositories;

import devflix.data.mappers.MovieCountryMapper;
import devflix.data.repositories.MovieCountryRepository;
import devflix.models.MovieCountry;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieCountryJdbcTemplateRepository implements MovieCountryRepository {
    private final JdbcTemplate jdbcTemplate;
    public MovieCountryJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MovieCountry> findMovieCountry(int movieID) {
        final String sql = """
                select
                    mc.movie_id , mc.country_id ,
                    c.name
                from movie_country mc
                inner join country c on mc.country_id = c.country_id
                where mc.movie_id = ?
                """;

        return jdbcTemplate.query(sql , new MovieCountryMapper() , movieID);
    }
}
