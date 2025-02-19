package org.example.learningprojectspring.moviestore;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVMovieProcessor {
    public List<Movie> readAndParseMovies(String filePath){
        List<Movie> movies = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))){
            String[] fileLine;
            csvReader.readNext();
            while ((fileLine = csvReader.readNext()) != null) {
                Movie parsedMovie = parseMovieData(fileLine);

                if(parsedMovie != null){
                    movies.add(parsedMovie);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return movies;
    }

    private Movie parseMovieData(String[] fileLine){
        try{
            String movieTitle = fileLine[1];
            String movieGenres = fileLine[2];
            String movieDescription = fileLine[3];
            String movieDirector = fileLine[4];
            String movieActors = fileLine[5];

            int movieYear = Integer.parseInt(fileLine[6]);
            int movieRuntime = Integer.parseInt(fileLine[7]);

            float movieRating = Float.parseFloat(fileLine[8]);

            return new Movie(movieTitle, movieGenres, movieDescription, movieDirector, movieActors, movieYear, movieRuntime, movieRating);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
