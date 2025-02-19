package org.example.learningprojectspring.moviestore;

import org.example.learningprojectspring.repositories.MovieRepository;
import org.example.learningprojectspring.services.MovieReaderService;
import org.example.learningprojectspring.services.MovieValidatorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieReaderImpl implements MovieReaderService {
    private final MovieRepository movieRepository;
    private final CSVMovieProcessor csvMovieProcessor;
    private final MovieValidatorService movieValidatorService;


    public MovieReaderImpl(MovieRepository movieRepository, CSVMovieProcessor csvMovieProcessor, MovieValidatorService movieValidatorService) {
        this.movieRepository = movieRepository;
        this.csvMovieProcessor = csvMovieProcessor;
        this.movieValidatorService = movieValidatorService;
    }

    @Override
    public List<Movie> readMovieData(String fileName) {
        List<Movie> movies = csvMovieProcessor.readAndParseMovies(fileName);

        List<Movie> validMovies = new ArrayList<>();

        for(Movie movie : movies) {
            try{
                movieValidatorService.validateMovie(movie);
                validMovies.add(movie);
            }
            catch(Exception e) {
                e.printStackTrace();
            }

        }
        return movieRepository.saveAll(validMovies);
    }
}
