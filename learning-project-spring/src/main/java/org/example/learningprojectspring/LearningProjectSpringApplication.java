package org.example.learningprojectspring;

import org.example.learningprojectspring.configuration.ProjectConfiguration;
import org.example.learningprojectspring.moviestore.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LearningProjectSpringApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        Movie movie1 = context.getBean("movie", Movie.class);
        System.out.println(movie1.getMovieGenre());
    }

}
