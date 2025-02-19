package org.example.learningprojectspring;

import org.example.learningprojectspring.configuration.ProjectConfiguration;
import org.example.learningprojectspring.moviestore.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LearningProjectSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningProjectSpringApplication.class, args);

    }

}
