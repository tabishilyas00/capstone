package webscrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WebScraper {
    public static void scrape() throws IOException {
        final String url = "https://www.imdb.com/chart/top/?ref_=nv_mv_250";
        final String imdbURL = "https://www.imdb.com";

        Document doc = Jsoup.connect(url).get();

        Elements body = doc.select("li.ipc-metadata-list-summary-item");

        for (Element e : body.select("li")) {
            String movieURL = imdbURL + e.select("a.ipc-lockup-overlay").attr("href");
            Document movie = Jsoup.connect(movieURL).get();

            Elements moreInfo = movie.select("ul.ipc-metadata-list.ipc-metadata-list--dividers-all.ipc-metadata-list--base");
            String more = moreInfo.select("li.ipc-metadata-list__item").text();
            String country;
            if (!more.contains("Official")) {
                country = more.substring(more.indexOf("origin" , more.indexOf("date")) + 7 , more.indexOf("Language") - 1);
            } else {
                country = more.substring(more.indexOf("origin" , more.indexOf("date")) + 7 , more.indexOf("Official") - 1);
            }
            String language;
            if (!more.contains("Languages")) {
                language = more.substring(more.indexOf("Language") + 9 , more.indexOf("Also") - 1);
            } else {
                language = more.substring(more.indexOf("Languages") + 10 , more.indexOf("Also") - 1);
            }

            System.out.println("Country(s)  : " + country);
            System.out.println("Language(s) : " + language);

            System.out.println();
        }
    }
}