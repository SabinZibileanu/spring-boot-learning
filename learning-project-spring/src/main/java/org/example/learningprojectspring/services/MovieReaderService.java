package org.example.learningprojectspring.services;
import org.example.learningprojectspring.moviestore.Movie;
import java.util.List;

public interface MovieReaderService {
    public List<Movie> readMovieData(String fileName);

}
