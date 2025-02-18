package org.example.learningprojectspring.configuration;

import org.example.learningprojectspring.moviestore.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {
    @Bean
    public Movie movie(){
        Movie movie = new Movie();
        movie.setMovieTitle("Spider-man 4");
        movie.setMovieGenre("Action");
        return movie;
    }


}
