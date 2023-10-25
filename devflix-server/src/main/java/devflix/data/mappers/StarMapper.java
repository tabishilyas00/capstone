package devflix.data.mappers;

import devflix.models.Star;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StarMapper implements RowMapper<Star> {
    @Override
    public Star mapRow(ResultSet rs, int rowNum) throws SQLException {
        Star star = new Star();
        star.setMovieID(rs.getInt("movie_id"));

        PersonMapper personMapper = new PersonMapper();
        star.setStar(personMapper.mapRow(rs , rowNum));

        return star;
    }
}
