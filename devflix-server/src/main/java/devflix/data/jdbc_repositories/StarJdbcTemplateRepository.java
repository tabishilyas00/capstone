package devflix.data.jdbc_repositories;

import devflix.data.mappers.StarMapper;
import devflix.data.repositories.StarRepository;
import devflix.models.Star;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StarJdbcTemplateRepository implements StarRepository {
    private final JdbcTemplate jdbcTemplate;
    public StarJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Star> findMovieStar(int movieID) {
        final String sql = """
                select
                    ms.movie_id , ms.star_id ,
                    s.name      , s.imageURL , s.person_id
                from movie_star ms
                inner join person s on ms.star_id = s.person_id
                where ms.movie_id = ?
                """;

        return jdbcTemplate.query(sql , new StarMapper() , movieID);
    }
}
