package devflix.data;

import devflix.data.jdbc_repositories.MovieJdbcTemplateRepository;
import devflix.models.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class MovieJdbctemplateRepositoryTest {
    @Autowired
    MovieJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindMovies() {
        List<Movie> movies = repository.findAll();
        assertNotNull(movies);
        assertTrue(movies.size() > 0);
    }

    @Test
    void shouldFindTWBB() {
        Movie twbb = repository.findByID(1);
        assertEquals("There Will Be Blood" , twbb.getTitle());
    }
}
