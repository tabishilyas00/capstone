package devflix.data.jdbc_repositories;

import devflix.data.repositories.MovieRepository;
import devflix.models.Movie;
import devflix.models.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class MovieJdbcTemplateRepository implements MovieRepository {
    private final JdbcTemplate jdbcTemplate;
    public MovieJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public Movie findByTitle(String title) {
        return null;
    }

    @Override
    public Movie findByYear(String year) {
        return null;
    }

    @Override
    public Movie findByRating(String rating) {
        return null;
    }

    @Override
    public Movie findByDirector(Person director) {
        return null;
    }

    @Override
    public Movie findByWriter(Person writer) {
        return null;
    }

    @Override
    public Movie findByStar(Person star) {
        return null;
    }

    @Override
    public Movie add(Movie movie) {
        final String sql = "insert into movie (title , `year` , rating , run_time , poster) values (? , ? , ? , ? , ?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getYear());
            ps.setString(3, movie.getRating());
            ps.setString(4, movie.getRunTime());
            ps.setString(5, movie.getPosterURL());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        movie.setMovieID(keyHolder.getKey().intValue());
        return movie;
    }

    @Override
    public boolean update(Movie movie) {
        return false;
    }

    @Override
    public boolean deleteByID(int movieID) {
        return false;
    }
}
