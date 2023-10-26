package devflix.data;

import devflix.data.jdbc_repositories.MovieCountryJdbcTemplateRepository;
import devflix.models.MovieCountry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MovieCountryJdbcTemplateRepositoryTest {
    @Autowired
    MovieCountryJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindCountries() {
        List<MovieCountry> countries = repository.findMovieCountry(1);
        assertNotNull(countries);
        assertTrue(countries.size() > 0);
    }
}
