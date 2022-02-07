package com.duncbh.movieapp;

import com.duncbh.movieapp.datalayer.Movie;
import com.duncbh.movieapp.presentationlayer.MovieListerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class MovieAppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MovieAppApplication.class, args);

        MovieListerController lister = context.getBean(MovieListerController.class);

        List<Movie> movies = lister.getAllMovies();

        for (Movie movie : movies) {
            System.out.println(movie.getTitle() + " / " + movie.getDirector());
        }
    }

}
