package webscrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StarScraper {
    public static void scrape() throws IOException, SQLException {
        final String url = "https://www.imdb.com/chart/top/?ref_=nv_mv_250";
        final String imdbURL = "https://www.imdb.com";

        Document top = Jsoup.connect(url).get();
        Elements body = top.select("li.ipc-metadata-list-summary-item");

        String title;
        for (Element e : body.select("li")) {
            String movieURL = imdbURL + e.select("a.ipc-lockup-overlay").attr("href");
            Document movie = Jsoup.connect(movieURL).get();

            Elements header = movie.select("div.sc-dffc6c81-0");
            title = header.select("h1.sc-aFE43DEF-0 span.sc-afe43def-1").text();

            Elements crewDiv = movie.select("div.sc-dffc6c81-3.jFHENY");
            List<Element> crewNameLists = crewDiv.select("li.ipc-metadata-list__item").stream().toList();
            List<Element> starList = new ArrayList<>();
            for (Element c : crewNameLists) {
                if (c.text().contains("Star")) {
                    starList = c.select("li.ipc-inline-list__item").stream().toList();
                }
            }

            System.out.println("Title : " + title);
            for (Element s : starList) {
                System.out.println("Star  : " + s.text());
            }
            System.out.println();
        }
    }
}
