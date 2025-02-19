package org.example.learningprojectspring.controllers;

import org.example.learningprojectspring.moviestore.Movie;
import org.example.learningprojectspring.services.MovieReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieReaderService movieReaderService;
    private final static String FILE_MOVIES_DATA = "utils/IMDB-Movie-Data.csv";

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieReaderService.readMovieData(FILE_MOVIES_DATA);
    }

}
