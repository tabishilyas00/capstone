import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

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

            System.out.println("Title    : " + title);
            System.out.println("Year     : " + year);
            System.out.println("Rating   : " + rating);
            System.out.println("Run Time : " + runTime);

            System.out.println();
        }
    }
}