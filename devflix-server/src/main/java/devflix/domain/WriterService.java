package devflix.domain;

import devflix.data.repositories.WriterRepository;
import devflix.models.Writer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterService {
    private final WriterRepository writerRepository;
    public WriterService(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    public List<Writer> findMovieWriter(int movieID) {return writerRepository.findMovieWriter(movieID);}
}
