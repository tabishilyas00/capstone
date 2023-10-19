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

public class MovieScraper {
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

            String year = basicInfo.select("li.ipc-inline-list__item").text().substring(0 , 4);

            String rating;
            String runTime;
            try {
                rating = basicInfo.select("a.ipc-link.ipc-link--baseAlt.ipc-link--inherit-color").text().substring(5);
                runTime = basicInfo.select("li.ipc-inline-list__item").text().substring(year.length() + rating.length() + 2);
            } catch (StringIndexOutOfBoundsException i) {
                rating = "Not Rated";
                runTime = basicInfo.select("li.ipc-inline-list__item").text().substring(year.length() + 1);
            }

            Elements poster = movie.select("div.ipc-poster.ipc-poster--baseAlt.ipc-poster--dynamic-width.sc-30a29d44-0.dktfIa.ipc-sub-grid-item.ipc-sub-grid-item--span-2");
            String posterURL = poster.select("div.ipc-media.ipc-media--poster-27x40.ipc-image-media-ratio--poster-27x40.ipc-media--baseAlt.ipc-media--poster-l.ipc-poster__poster-image.ipc-media__img img").attr("src");

            Connection conn = DriverManager.getConnection(System.getenv("DB_URL") , System.getenv("DB_USERNAME") , System.getenv("DB_PASSWORD"));
            PreparedStatement pstmt =
                    conn.prepareStatement("insert into movie (title , `year` , rating , run_time , poster) values (? , ? , ? , ? , ?)");
            pstmt.setString(1, title);
            pstmt.setString(2, year);
            pstmt.setString(3, rating);
            pstmt.setString(4, runTime);
            pstmt.setString(5, posterURL);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
    }
}
