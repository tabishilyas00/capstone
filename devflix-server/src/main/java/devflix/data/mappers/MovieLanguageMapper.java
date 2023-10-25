package devflix.data.mappers;

import devflix.models.MovieLanguage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieLanguageMapper implements RowMapper<MovieLanguage> {
    @Override
    public MovieLanguage mapRow(ResultSet rs, int rowNum) throws SQLException {
        MovieLanguage movieLanguage = new MovieLanguage();
        movieLanguage.setMovieID(rs.getInt("movie_id"));

        LanguageMapper languageMapper = new LanguageMapper();
        movieLanguage.setLanguage(languageMapper.mapRow(rs , rowNum));

        return movieLanguage;
    }
}
