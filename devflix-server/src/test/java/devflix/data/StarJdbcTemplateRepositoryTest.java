package devflix.data;

import devflix.data.jdbc_repositories.StarJdbcTemplateRepository;
import devflix.models.Star;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StarJdbcTemplateRepositoryTest {
    @Autowired
    StarJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindStars() {
        List<Star> stars = repository.findMovieStar(1);
        assertNotNull(stars);
        assertTrue(stars.size() > 0);
    }
}
