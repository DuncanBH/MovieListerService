package com.duncbh.movieapp;

import com.duncbh.movieapp.datalayer.Movie;
import com.duncbh.movieapp.presentationlayer.MovieListerController;
import com.duncbh.movieapp.presentationlayer.MovieResponseModel;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@SpringBootApplication
public class MovieAppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MovieAppApplication.class, args);

        MovieListerController lister = context.getBean(MovieListerController.class);

        List<MovieResponseModel> movies = lister.getAllMovies();

        for (MovieResponseModel movie : movies) {
            System.out.println(movie.getTitle() + " / " + movie.getDirector());
        }
    }

}
