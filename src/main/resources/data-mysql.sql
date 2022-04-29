insert ignore into languages(languageId, name) values ('100','English');
insert ignore into languages(languageId, name) values ('200','French');
insert ignore into languages(languageId, name) values ('300','Italian');
insert ignore into languages(languageId, name) values ('400','Spanish');
insert ignore into languages(languageId, name) values ('500','Mandarin');
insert ignore into languages(languageId, name) values ('600','Portuguese');

insert ignore into movies(movieId, title, director, languageId) values('101','The Aviator', 'Martin Scorsese', '100');
insert ignore into movies(movieId, title, director, languageId) values('102','Gangs of New York', 'Martin Scorsese', '200');
insert ignore into movies(movieId, title, director, languageId) values('103','E.T.: The Extra-Terrestial', 'Steven Spielberg', '300');
insert ignore into movies(movieId, title, director, languageId) values('104','Edward ScissorHands', 'Tim Burton', '400');
insert ignore into movies(movieId, title, director, languageId) values('105','Indiana Jones and the Temple of Doom', 'Steven Spielberg', '400');
insert ignore into movies(movieId, title, director, languageId) values('106','Jurassic Park', 'Steven Spielberg', '500');
insert ignore into movies(movieId, title, director, languageId) values('107','The Lego Movie','Phil Lord and Chris Miller', '100');