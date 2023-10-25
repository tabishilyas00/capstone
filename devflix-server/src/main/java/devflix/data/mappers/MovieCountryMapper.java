package devflix.data.mappers;

import devflix.models.MovieCountry;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieCountryMapper implements RowMapper<MovieCountry> {
    @Override
    public MovieCountry mapRow(ResultSet rs, int rowNum) throws SQLException {
        MovieCountry movieCountry = new MovieCountry();
        movieCountry.setMovieID(rs.getInt("movie_id"));

        CountryMapper countryMapper = new CountryMapper();
        movieCountry.setCountry(countryMapper.mapRow(rs , rowNum));

        return movieCountry;
    }
}
