package devflix.data.jdbc_repositories;

import devflix.data.mappers.*;
import devflix.data.repositories.MovieRepository;
import devflix.models.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MovieJdbcTemplateRepository implements MovieRepository {
    private final JdbcTemplate jdbcTemplate;
    public MovieJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> findAll() {
        final String sql = """
                select
                    movie_id , title , year , rating , run_time , poster
                from movie;
                """;

        return jdbcTemplate.query(sql , new MovieMapper());
    }

    @Override
    @Transactional
    public Movie findByID(int movieID) {
        final String sql = """
                select
                    movie_id , title , year , rating , run_time , poster
                from movie
                where movie_id = ?;
                """;

        Movie movie = jdbcTemplate.query(sql , new MovieMapper() , movieID).stream().findAny().orElse(null);

        if (movie != null) {
            addDirectors(movie);
            addWriters(movie);
            addStars(movie);
            addCountries(movie);
            addLanguages(movie);
        }

        return movie;
    }

    private void addDirectors(Movie movie) {
        final String sql = """
                select
                    md.movie_id , md.director_id ,
                    d.name      , d.imageURL
                from movie_director md
                inner join person d on md.director_id = d.person_id
                where md.movie_id = ?;
                """;

        var directors = jdbcTemplate.query(sql , new DirectorMapper() , movie.getMovieID());
        movie.setDirectorList(directors);
    }

    private void addWriters(Movie movie) {
        final String sql = """
                select
                    mw.movie_id , mw.writer_id ,
                    w.name      , w.imageURL
                from movie_writer mw
                inner join person w on mw.writer_id = w.person_id
                where mw.movie_id = ?;
                """;

        var writers = jdbcTemplate.query(sql , new WriterMapper() , movie.getMovieID());
        movie.setWriterList(writers);
    }

    private void addStars(Movie movie) {
        final String sql = """
                select
                    ms.movie_id , ms.star_id ,
                    s.name      , s.imageURL
                from movie_star ms
                inner join person s on ms.star_id = s.person_id
                where ms.movie_id = ?;
                """;

        var stars = jdbcTemplate.query(sql , new StarMapper() , movie.getMovieID());
        movie.setStarList(stars);
    }

    private void addCountries(Movie movie) {
        final String sql = """
                select
                    mc.movie_id , mc.country_id ,
                    c.name
                from movie_country mc
                inner join country c on mc.country_id = c.country_id
                where mc.movie_id = ?;
                """;

        var countries = jdbcTemplate.query(sql , new MovieCountryMapper() , movie.getMovieID());
        movie.setCountry(countries);
    }

    private void addLanguages(Movie movie) {
        final String sql = """
                select
                    ml.movie_id , ml.language_id ,
                    l.name
                from movie_language ml
                inner join lang l on ml.language_id = l.language_id
                where ml.movie_id = ?;
                """;

        var languages = jdbcTemplate.query(sql , new MovieLanguageMapper() , movie.getMovieID());
        movie.setLanguage(languages);
    }
}
