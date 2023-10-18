package devflix.data.mappers;

import devflix.models.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();

        movie.setMovieID(rs.getInt("movie_id"));
        movie.setTitle(rs.getString("title"));
        movie.setYear(rs.getString("year"));
        movie.setRating(rs.getString("rating"));
        movie.setRunTime(rs.getString("run_time"));
        movie.setPosterURL(rs.getString("poster"));

        return movie;
    }
}
