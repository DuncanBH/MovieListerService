package com.duncbh.movieapp.datalayer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="movies")
@NoArgsConstructor
@Setter
@Getter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "movieid")
    private Integer movieId;

    private Integer id; //private id

    private String title;
    private String director;
}
