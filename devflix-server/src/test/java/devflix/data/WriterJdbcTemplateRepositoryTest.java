package devflix.data;

import devflix.data.jdbc_repositories.WriterJdbcTemplateRepository;
import devflix.models.Writer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class WriterJdbcTemplateRepositoryTest {
    @Autowired
    WriterJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindWriters() {
        List<Writer> writers = repository.findMovieWriter(1);
        assertNotNull(writers);
        assertTrue(writers.size() > 0);
    }
}
