package com.duncbh.movieapp.datalayer;

import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapping;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="languageid", unique = true)
    private Integer languageId;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "language")
    private Set<Movie> movies = new HashSet<Movie>(0);
}
