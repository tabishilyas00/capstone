package devflix.data.jdbc_repositories;

import devflix.data.mappers.DirectorMapper;
import devflix.data.repositories.DirectorRepository;
import devflix.models.Director;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DirectorJdbcTemplateRepository implements DirectorRepository {
    private final JdbcTemplate jdbcTemplate;
    public DirectorJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Director> findMovieDirector(int movieID) {
        final String sql = """
                select
                    md.movie_id , md.director_id ,
                    d.name      , d.imageURL , d.person_id
                from movie_director md
                inner join person d on md.director_id = d.person_id
                where md.movie_id = ?
                """;

        return jdbcTemplate.query(sql , new DirectorMapper() , movieID);
    }
}
