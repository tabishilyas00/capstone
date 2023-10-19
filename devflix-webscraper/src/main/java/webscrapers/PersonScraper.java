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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PersonScraper {
    public static void scrape() throws IOException, SQLException {
        final String url = "https://www.imdb.com/chart/top/?ref_=nv_mv_250";
        final String imdbURL = "https://www.imdb.com";

        Document doc = Jsoup.connect(url).get();

        Elements top = doc.select("li.ipc-metadata-list-summary-item");

        HashMap<String , String> crewNameImageMap = new HashMap<>();
        for (Element e : top.select("li")) {
            String movieURL = imdbURL + e.select("a.ipc-lockup-overlay").attr("href");
            Document movie = Jsoup.connect(movieURL).get();

            Elements crewNames = movie.select("ul.ipc-metadata-list.ipc-metadata-list--dividers-all.title-pc-list.ipc-metadata-list--baseAlt");
            List<Element> crewArray = crewNames.select("a.ipc-metadata-list-item__list-content-item.ipc-metadata-list-item__list-content-item--link").stream().toList();

            for (Element c : crewArray) {
                String crewLink = imdbURL + c.attr("href");
                Document crewDoc = Jsoup.connect(crewLink).get();

                String name = c.text();

                Elements image = crewDoc.select("div.ipc-poster.ipc-poster--baseAlt.ipc-poster--dynamic-width.ipc-sub-grid-item.ipc-sub-grid-item--span-2");
                String imageURL = image.select("div.ipc-media.ipc-media--poster-27x40.ipc-image-media-ratio--poster-27x40.ipc-media--baseAlt.ipc-media--poster-m.ipc-poster__poster-image.ipc-media__img img").attr("src");
                crewNameImageMap.put(name , imageURL);
            }
        }

        for (String name : crewNameImageMap.keySet()) {
            System.out.println("Name      : " + name);
            System.out.println("Image URL : " + crewNameImageMap.get(name));

            Connection conn = DriverManager.getConnection(System.getenv("DB_URL") , System.getenv("DB_USERNAME") , System.getenv("DB_PASSWORD"));
            PreparedStatement pstmt =
                    conn.prepareStatement("insert into person (`name` , imageURL) values (? , ?)");
            pstmt.setString(1, name);
            pstmt.setString(2, crewNameImageMap.get(name));
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
    }
}
