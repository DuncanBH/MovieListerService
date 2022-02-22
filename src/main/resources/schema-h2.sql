drop table movies if exists;
drop table languages if exists;

CREATE SEQUENCE language_language_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE CACHE 1;

CREATE TABLE languages
(
    id         INT                                             NOT NULL AUTO_INCREMENT,
    languageId INT DEFAULT nextval('language_language_id_seq') NOT NULL,
    name       VARCHAR(20)                                     NOT NULL,
    PRIMARY KEY (id)
);

create table movies
(
    id         INT          NOT NULL AUTO_INCREMENT,
    movieId    INT          NOT NULL UNIQUE,
    title      VARCHAR(255) NOT NULL,
    director   VARCHAR(255) NOT NULL,
    languageId INT          NOT NULL,
    PRIMARY KEY (id)
);