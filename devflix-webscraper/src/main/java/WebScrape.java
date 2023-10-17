import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScrape {
    public static void main(String[] args) throws IOException {
        final String url = "https://www.imdb.com/chart/top/?ref_=nv_mv_250";
        final String imdbURL = "https://www.imdb.com";

        Document doc = Jsoup.connect(url)
                .get();

        Elements body = doc.select("li.ipc-metadata-list-summary-item");

        for (Element e : body.select("li")) {
            String movieURL = imdbURL + e.select("a.ipc-lockup-overlay").attr("href");
            Document movie = Jsoup.connect(movieURL).get();
            Elements basicInfo = movie.select("div.sc-dffc6c81-0");
            String title = basicInfo.select("h1.sc-aFE43DEF-0 span.sc-afe43def-1").text();
            String year = basicInfo.select("li.ipc-inline-list__item").text().substring(0 , 4);
            String rating = basicInfo.select("a.ipc-link.ipc-link--baseAlt.ipc-link--inherit-color").text().substring(5);
            String runTime = basicInfo.select("li.ipc-inline-list__item").text().substring(year.length() + rating.length() + 2);

            Elements poster = movie.select("div.ipc-poster.ipc-poster--baseAlt.ipc-poster--dynamic-width.sc-30a29d44-0.dktfIa.ipc-sub-grid-item.ipc-sub-grid-item--span-2");
            String posterURL = poster.select("div.ipc-media.ipc-media--poster-27x40.ipc-image-media-ratio--poster-27x40.ipc-media--baseAlt.ipc-media--poster-l.ipc-poster__poster-image.ipc-media__img img").attr("src");

            Elements crewInfo = movie.select("ul.ipc-metadata-list.ipc-metadata-list--dividers-all.title-pc-list.ipc-metadata-list--baseAlt");
            String c = crewInfo.select("li.ipc-metadata-list__item").text();
            String crew = c.substring((c.length() / 2) + 1);
            String director;
            if (!crew.contains("Writers")) {
                director = crew.substring(crew.indexOf("Director") + 9 , crew.indexOf("Writer"));
            } else {
                director = crew.substring(crew.indexOf("Director") + 9 , crew.indexOf("Writers"));
            }
            String writers;
            if (!crew.contains("Writers")) {
                writers = crew.substring(crew.indexOf("Writer") + 7 , crew.indexOf("Stars"));
            } else {
                writers = crew.substring(crew.indexOf("Writers") + 8 , crew.indexOf("Stars"));
            }
            String stars = crew.substring(crew.indexOf("Stars") + 6);

            

            System.out.println("Title      : " + title);
            System.out.println("Year       : " + year);
            System.out.println("Rating     : " + rating);
            System.out.println("Run Time   : " + runTime);
            System.out.println("Poster URL : " + posterURL);
            System.out.println("Director   : " + director);
            System.out.println("Writer(s)  : " + writers);
            System.out.println("Stars      : " + stars);

            System.out.println();
        }
    }
}