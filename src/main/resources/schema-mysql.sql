USE `movielister-db`;

/*fix this*/
drop table if exists movies;
drop table if exists languages;

create table if not exists languages
(
    id         INTEGER     NOT NULL AUTO_INCREMENT PRIMARY KEY,
    languageId INTEGER     NOT NULL UNIQUE,
    name       VARCHAR(20) NOT NULL
) engine = InnoDB;

create table if not exists movies
(
    id         INTEGER      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    movieId    INTEGER      NOT NULL UNIQUE,
    title      VARCHAR(255) NOT NULL,
    director   VARCHAR(255) NOT NULL,
    languageId INTEGER      NOT NULL
) engine = InnoDB;