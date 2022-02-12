drop table movies if exists;

create table movies
(
    id       INT          NOT NULL AUTO_INCREMENT,
    movieId  INT          NOT NULL UNIQUE,
    title    VARCHAR(255) NOT NULL,
    director VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);