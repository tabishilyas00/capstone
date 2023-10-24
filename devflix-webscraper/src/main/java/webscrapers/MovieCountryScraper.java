package webscrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieCountryScraper {
    public static void scrape() throws IOException, SQLException {
        Connection conn = DriverManager.getConnection(System.getenv("DB_URL") , System.getenv("DB_USERNAME") , System.getenv("DB_PASSWORD"));

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

            int movieID = findMovieID(title , conn);

            System.out.printf("Movie ID : %d%n" , movieID);
            System.out.println("Title    : " + title);
            for (Element c : countryList) {
                int countryID = findCountryID(c.text() , conn);

                System.out.printf("Person ID : %d%n" , countryID);
                System.out.println("Country   : " + c.text());

                addCountry(movieID , countryID , conn);
            }
            System.out.println();
        }

        conn.close();
    }

    public static int findMovieID(String title , Connection conn) throws SQLException {
        final String sql = """
                select
                    movie_id
                from movie
                where title = ?;
                """;

        PreparedStatement pstmt =
                conn.prepareStatement(sql);
        pstmt.setString(1, title);

        ResultSet rs = pstmt.executeQuery();
        int movieID = 0;
        while (rs.next()) {
            movieID = rs.getInt("movie_id");
        }

        rs.close();
        pstmt.close();
        return movieID;
    }

    public static int findCountryID(String name , Connection conn) throws SQLException {
        final String sql = """
                select
                    country_id
                from country
                where name = ?;
                """;

        PreparedStatement pstmt =
                conn.prepareStatement(sql);
        pstmt.setString(1, name);

        ResultSet rs = pstmt.executeQuery();
        int movieID = 0;
        while (rs.next()) {
            movieID = rs.getInt("country_id");
        }

        rs.close();
        pstmt.close();
        return movieID;
    }

    public static void addCountry(int movieID , int countryID , Connection conn) throws SQLException {
        final String sql = """
                insert into movie_country (movie_id , country_id) values (? , ?)
                """;

        PreparedStatement pstmt =
                conn.prepareStatement(sql);
        pstmt.setString(1, String.valueOf(movieID));
        pstmt.setString(2, String.valueOf(countryID));
        pstmt.executeUpdate();
        pstmt.close();
    }
}
