import webscrapers.MovieScraper;
import webscrapers.PersonScraper;
import webscrapers.WebScraper;

import java.io.IOException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws IOException, SQLException {
//        MovieScraper.scrape();
//        PersonScraper.scrape();
        WebScraper.scrape();
    }
}
