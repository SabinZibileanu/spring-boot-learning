package org.example.learningprojectspring.moviestore;

import org.example.learningprojectspring.services.MovieValidatorService;
import org.springframework.stereotype.Service;

@Service
public class MovieValidatorImpl implements MovieValidatorService {
    @Override
    public void validateMovie(Movie movie) {
        if (movie.getMovieYear() < 1900 || movie.getMovieYear() > 2028) {
            System.out.println("Error when validating the movie: " + movie.getMovieTitle());
            throw new IllegalArgumentException("Invalid movie year");
        }

        if (movie.getMovieRating() < 1 || movie.getMovieRating() > 10) {
            System.out.println("Error when validating the movie: " + movie.getMovieTitle());
            throw new IllegalArgumentException("Invalid movie rating");
        }

        if (movie.getMovieRuntime() < 1 || movie.getMovieRuntime() > 280) {
            System.out.println("Error when validating the movie: " + movie.getMovieTitle());
            throw new IllegalArgumentException("Invalid movie runtime");
        }
    }
}
