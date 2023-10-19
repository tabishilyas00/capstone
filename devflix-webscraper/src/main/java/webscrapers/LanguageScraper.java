package webscrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

public class LanguageScraper {
    public static void scrape() throws IOException, SQLException {
        final String url = "https://www.imdb.com/chart/top/?ref_=nv_mv_250";
        final String imdbURL = "https://www.imdb.com";

        Document top = Jsoup.connect(url).get();

        Elements body = top.select("li.ipc-metadata-list-summary-item");

        HashSet<String> language = new HashSet<>();
        for (Element e : body.select("li")) {
            String movieURL = imdbURL + e.select("a.ipc-lockup-overlay").attr("href");
            Document movie = Jsoup.connect(movieURL).get();

            Elements moreInfo = movie.select("ul.ipc-metadata-list.ipc-metadata-list--dividers-all.ipc-metadata-list--base");
            List<Element> more = moreInfo.select("li.ipc-metadata-list__item").stream().toList();

            for (Element m : more) {
                if (m.attr("data-testid").equals("title-details-languages")) {
                    List<Element> languageList = m.select("li.ipc-inline-list__item").stream().toList();
                    for (Element l : languageList) {
                        language.add(l.text());
                    }
                }
            }
        }

        for (String l : language) {
            Connection conn = DriverManager.getConnection(System.getenv("DB_URL") , System.getenv("DB_USERNAME") , System.getenv("DB_PASSWORD"));
            PreparedStatement pstmt =
                    conn.prepareStatement("insert into lang (`name`) values (?)");
            pstmt.setString(1, l);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
    }
}
