package devflix.webscrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraper {
    public static void scrape() throws IOException {
        final String url = "https://www.imdb.com/chart/top/?ref_=nv_mv_250";
        final String imdbURL = "https://www.imdb.com";

        Document doc = Jsoup.connect(url).get();

        Elements body = doc.select("li.ipc-metadata-list-summary-item");

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

            Elements crewInfo = movie.select("ul.ipc-metadata-list.ipc-metadata-list--dividers-all.title-pc-list.ipc-metadata-list--baseAlt");
            String crew = crewInfo.select("li.ipc-metadata-list__item").text();
            String director;
            if (!crew.contains("Writers")) {
                if (!crew.contains("Directors")) {
                    director = crew.substring(crew.indexOf("Director") + 9 , crew.indexOf("Writer") - 1);
                } else {
                    director = crew.substring(crew.indexOf("Directors") + 10 , crew.indexOf("Writer") - 1);
                }
            } else {
                if (!crew.contains("Directors")) {
                    director = crew.substring(crew.indexOf("Director") + 9 , crew.indexOf("Writers") - 1);
                } else {
                    director = crew.substring(crew.indexOf("Directors") + 10 , crew.indexOf("Writers") - 1);
                }
            }
            String writers;
            if (!crew.contains("Writers")) {
                writers = crew.substring(crew.indexOf("Writer") + 7 , crew.indexOf("Stars") - 1);
            } else {
                writers = crew.substring(crew.indexOf("Writers") + 8 , crew.indexOf("Stars") - 1);
            }
            String stars = crew.substring(crew.indexOf("Stars") + 6 , crew.indexOf("Director" , crew.indexOf("Stars")) - 1);

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

            System.out.println("Title       : " + title);
            System.out.println("Year        : " + year);
            System.out.println("Rating      : " + rating);
            System.out.println("Run Time    : " + runTime);
            System.out.println("Poster URL  : " + posterURL);
            System.out.println("Director(s) : " + director);
            System.out.println("Writer(s)   : " + writers);
            System.out.println("Stars       : " + stars);
            System.out.println("Country(s)  : " + country);
            System.out.println("Language(s) : " + language);

            System.out.println();
        }
    }
}