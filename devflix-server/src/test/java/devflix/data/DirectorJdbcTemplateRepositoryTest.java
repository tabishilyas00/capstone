package devflix.data;

import devflix.data.jdbc_repositories.DirectorJdbcTemplateRepository;
import devflix.models.Director;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DirectorJdbcTemplateRepositoryTest {
    @Autowired
    DirectorJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindDirectors() {
        List<Director> directors = repository.findMovieDirector(1);
        assertNotNull(directors);
        assertTrue(directors.size() > 0);
    }
}
