USE `movielister-db`;

create table if not exists movies
(
    id       INTEGER      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    movieId  INTEGER      NOT NULL UNIQUE,
    title    VARCHAR(255) NOT NULL,
    director VARCHAR(255) NOT NULL
) engine=InnoDB;