package devflix.data.jdbc_repositories;

import devflix.data.mappers.WriterMapper;
import devflix.data.repositories.WriterRepository;
import devflix.models.Writer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WriterJdbcTemplateRepository implements WriterRepository {
    private final JdbcTemplate jdbcTemplate;
    public WriterJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Writer> findMovieWriter(int movieID) {
        final String sql = """
                select
                    mw.movie_id , mw.writer_id ,
                    w.name      , w.imageURL , w.person_id
                from movie_writer mw
                inner join person w on mw.writer_id = w.person_id
                where mw.movie_id = ?
                """;

        return jdbcTemplate.query(sql , new WriterMapper() , movieID);
    }
}
