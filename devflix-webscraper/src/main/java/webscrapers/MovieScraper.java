package webscrapers;

import devflix.models.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MovieScraper {
    public void movieScrape() throws IOException {
        Movie film = new Movie();

        final String url = "https://www.imdb.com/chart/top/?ref_=nv_mv_250";
        final String imdbURL = "https://www.imdb.com";

        Document top = Jsoup.connect(url).get();
        Elements body = top.select("li.ipc-metadata-list-summary-item");

        for (Element e : body.select("li")) {
            String movieURL = imdbURL + e.select("a.ipc-lockup-overlay").attr("href");
            Document movie = Jsoup.connect(movieURL).get();
            Elements basicInfo = movie.select("div.sc-dffc6c81-0");

            String title = basicInfo.select("h1.sc-aFE43DEF-0 span.sc-afe43def-1").text();
            film.setTitle(title);

            String year = basicInfo.select("li.ipc-inline-list__item").text().substring(0 , 4);
            film.setYear(year);

            String rating;
            String runTime;
            try {
                rating = basicInfo.select("a.ipc-link.ipc-link--baseAlt.ipc-link--inherit-color").text().substring(5);
                runTime = basicInfo.select("li.ipc-inline-list__item").text().substring(year.length() + rating.length() + 2);
            } catch (StringIndexOutOfBoundsException i) {
                rating = "Not Rated";
                runTime = basicInfo.select("li.ipc-inline-list__item").text().substring(year.length() + 1);
            }
            film.setRating(rating);
            film.setRunTime(runTime);

            Elements poster = movie.select("div.ipc-poster.ipc-poster--baseAlt.ipc-poster--dynamic-width.sc-30a29d44-0.dktfIa.ipc-sub-grid-item.ipc-sub-grid-item--span-2");
            String posterURL = poster.select("div.ipc-media.ipc-media--poster-27x40.ipc-image-media-ratio--poster-27x40.ipc-media--baseAlt.ipc-media--poster-l.ipc-poster__poster-image.ipc-media__img img").attr("src");
            film.setPosterURL(posterURL);

            System.out.println("Title       : " + film.getTitle());
            System.out.println("Year        : " + film.getYear());
            System.out.println("Rating      : " + film.getRating());
            System.out.println("Run Time    : " + film.getRunTime());
            System.out.println("Poster URL  : " + film.getPosterURL());

            System.out.println();
        }
    }
}
