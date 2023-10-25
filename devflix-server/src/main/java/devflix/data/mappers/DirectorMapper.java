package devflix.data.mappers;

import devflix.models.Director;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorMapper implements RowMapper<Director> {
    @Override
    public Director mapRow(ResultSet rs, int rowNum) throws SQLException {
        Director director = new Director();
        director.setMovieID(rs.getInt("movie_id"));

        PersonMapper personMapper = new PersonMapper();
        director.setDirector(personMapper.mapRow(rs , rowNum));

        return director;
    }
}
