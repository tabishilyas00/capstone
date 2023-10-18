package devflix.models;

public class Star {
    private int movieID;
    private Person star;

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public Person getStar() {
        return star;
    }

    public void setStar(Person star) {
        this.star = star;
    }
}
