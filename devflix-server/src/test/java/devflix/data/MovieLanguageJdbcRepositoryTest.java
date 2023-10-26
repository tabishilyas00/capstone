package devflix.data;

import devflix.data.jdbc_repositories.MovieLanguageJdbcTemplateRepository;
import devflix.models.Director;
import devflix.models.MovieLanguage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MovieLanguageJdbcRepositoryTest {
    @Autowired
    MovieLanguageJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindLanguages() {
        List<MovieLanguage> languages = repository.findMovieLanguage(1);
        assertNotNull(languages);
        assertTrue(languages.size() > 0);
    }
}
