package org.example.learningprojectspring.controllers;
import org.example.learningprojectspring.moviestore.Movie;
import org.example.learningprojectspring.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class MovieController {
    @Autowired

    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

}
