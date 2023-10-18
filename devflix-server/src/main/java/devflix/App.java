package devflix;

import devflix.webscrapers.MovieScraper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws IOException {
//        WebScrape.scrape();
        MovieScraper.movieScrape();
    }
}
