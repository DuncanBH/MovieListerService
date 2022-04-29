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
    private Integer id; //private id

    @Column(unique = true, name = "movieid")
    private Integer movieId;
    private String title;
    private String director;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "languageid", referencedColumnName = "languageid", nullable = false)
    private Language language;
}
