package webscrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieCountryScraper {
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

            Elements moreInfo = movie.select("ul.ipc-metadata-list.ipc-metadata-list--dividers-all.ipc-metadata-list--base");
            List<Element> more = moreInfo.select("li.ipc-metadata-list__item").stream().toList();

            List<Element> countryList = new ArrayList<>();
            for (Element m : more) {
                if (m.attr("data-testid").equals("title-details-origin")) {
                    countryList = m.select("li.ipc-inline-list__item").stream().toList();
                }
            }

            System.out.println("Title   : " + title);
            for (Element c : countryList) {
                System.out.println("Country : " + c.text());
            }
            System.out.println();
        }
    }
}
