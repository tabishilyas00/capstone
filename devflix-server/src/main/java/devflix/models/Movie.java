package devflix.models;

import java.util.List;

public class Movie {
    private int movieID;
    private String title;
    private String year;
    private String rating;
    private String runTime;
    private String posterURL;
    private List<MovieCountry> country;
    private List<MovieLanguage> language;
    private List<Director> directorList;
    private List<Writer> writerList;
    private List<Star> starList;

    public Movie() {}
    public Movie(int movieID, String title, String year, String rating, String runTime, String posterURL) {
        this.movieID = movieID;
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.runTime = runTime;
        this.posterURL = posterURL;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public List<MovieCountry> getCountry() {
        return country;
    }

    public void setCountry(List<MovieCountry> country) {
        this.country = country;
    }

    public List<MovieLanguage> getLanguage() {
        return language;
    }

    public void setLanguage(List<MovieLanguage> language) {
        this.language = language;
    }

    public List<Director> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(List<Director> directorList) {
        this.directorList = directorList;
    }

    public List<Writer> getWriterList() {
        return writerList;
    }

    public void setWriterList(List<Writer> writerList) {
        this.writerList = writerList;
    }

    public List<Star> getStarList() {
        return starList;
    }

    public void setStarList(List<Star> starList) {
        this.starList = starList;
    }
}
