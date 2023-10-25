package devflix.data.mappers;

import devflix.models.Writer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WriterMapper implements RowMapper<Writer> {
    @Override
    public Writer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Writer writer = new Writer();
        writer.setMovieID(rs.getInt("movie_id"));

        PersonMapper personMapper = new PersonMapper();
        writer.setWriter(personMapper.mapRow(rs , rowNum));

        return writer;
    }
}
