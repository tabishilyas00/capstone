package webscrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectorScraper {
    public static void scrape() throws IOException, SQLException {
        final String url = "https://www.imdb.com/chart/top/?ref_=nv_mv_250";
        final String imdbURL = "https://www.imdb.com";

        Document top = Jsoup.connect(url).get();
        Elements body = top.select("li.ipc-metadata-list-summary-item");

        for (Element e : body.select("li")) {
            String movieURL = imdbURL + e.select("a.ipc-lockup-overlay").attr("href");
            Document movie = Jsoup.connect(movieURL).get();

            Elements basicInfo = movie.select("div.sc-dffc6c81-0");
            String title = basicInfo.select("h1.sc-aFE43DEF-0 span.sc-afe43def-1").text();
            System.out.println("Title : " + title);

            Elements crewList = movie.select("ul.ipc-metadata-list.ipc-metadata-list--dividers-all.title-pc-list.ipc-metadata-list--baseAlt");
            Elements directorSection = crewList.select("li.ipc-metadata-list__item");
            List<String> directorNameList = new ArrayList<>();
            if (directorSection.attr("data-testid").equals("title-pc-principal-credit") && (directorSection.select("span.ipc-metadata-list-item__label.ipc-metadata-list-item__label--btn").text().equals("Director") || directorSection.select("span.ipc-metadata-list-item__label.ipc-metadata-list-item__label--btn").text().equals("Directors"))) {
                List<Element> directorList = directorSection.select("a.ipc-metadata-list-item__list-content-item.ipc-metadata-list-item__list-content-item--link").stream().toList();
                for (Element d : directorList) {
                    directorNameList.add(d.text());
                }
            }

            for (String d : directorNameList) {
                System.out.println("Director : " + d);
            }
        }
    }
}