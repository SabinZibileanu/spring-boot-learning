package org.example.learningprojectspring.moviestore;
import jakarta.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition="TEXT", length = 2048)
    private String movieTitle, movieGenres, movieDescription, movieDirector, movieActors;
    private int movieYear, movieRuntime;
    private float movieRating;

    public Movie(String movieTitle, String movieGenres, String movieDescription, String movieDirector, String movieActors, int movieYear, int movieRuntime, float movieRating) {
        this.movieTitle = movieTitle;
        this.movieGenres = movieGenres;
        this.movieDescription = movieDescription;
        this.movieDirector = movieDirector;
        this.movieActors = movieActors;
        this.movieYear = movieYear;
        this.movieRuntime = movieRuntime;
        this.movieRating = movieRating;

    }

    public Movie() {

    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public int getMovieYear(){
        return movieYear;
    }

    public String getMovieGenres() {
        return movieGenres;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public String getMovieActors() {
        return movieActors;
    }

    public int getMovieRuntime(){
        return movieRuntime;
    }

    public float getMovieRating(){
        return movieRating;
    }


}
