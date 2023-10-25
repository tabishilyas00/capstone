drop database if exists devflix_test;
create database devflix_test;
use devflix_test;

create table movie (
    movie_id int primary key auto_increment,
    title varchar(100) not null,
    `year` varchar(4) not null,
    rating varchar(10) not null,
    run_time varchar(10) not null,
    poster varchar(1000) not null
);

create table person (
    person_id int primary key auto_increment,
    `name` varchar(50) not null,
    imageURL varchar(1000) null
);

create table country (
    country_id int primary key auto_increment,
    `name` varchar(25) not null
);

create table lang (
    language_id int primary key auto_increment,
    `name` varchar(25) not null
);

create table movie_director (
    movie_id int not null,
    director_id int not null,
    constraint pk_movie_director
        primary key (movie_id , director_id),
    constraint fk_movie_director_movie_id
        foreign key (movie_id)
        references movie(movie_id),
    constraint fk_movie_director_director_id
        foreign key (director_id)
        references person(person_id)
);

create table movie_writer (
    movie_id int not null,
    writer_id int not null,
    constraint pk_movie_writer
        primary key (movie_id , writer_id),
    constraint fk_movie_writer_movie_id
        foreign key (movie_id)
        references movie(movie_id),
    constraint fk_movie_writer_writer_id
        foreign key (writer_id)
        references person(person_id)
);

create table movie_star (
    movie_id int not null,
    star_id int not null,
    constraint pk_movie_star
        primary key (movie_id , star_id),
    constraint fk_movie_star_movie_id
        foreign key (movie_id)
        references movie(movie_id),
    constraint fk_movie_star_star_id
        foreign key (star_id)
        references person(person_id)
);

create table movie_country (
    movie_id int not null,
    country_id int not null,
    constraint pk_movie_country
        primary key (movie_id , country_id),
    constraint fk_movie_country_movie_id
        foreign key (movie_id)
        references movie(movie_id),
    constraint fk_movie_country_country_id
        foreign key (country_id)
        references country(country_id)
);

create table movie_language (
    movie_id int not null,
    language_id int not null,
    constraint pk_movie_language
        primary key (movie_id , language_id),
    constraint fk_movie_language_movie_id
        foreign key (movie_id)
        references movie(movie_id),
    constraint fk_movie_language_language_id
        foreign key (language_id)
        references lang(language_id)
);

delimiter //
create procedure set_known_good_state()
begin
	delete from movie;
    alter table movie auto_increment = 1;

    delete from person;
    alter table person auto_increment = 1;

    delete from country;
    alter table country auto_increment = 1;

    delete from lang;
    alter table lang auto_increment = 1;

    delete from movie_director;
    alter table movie_director auto_increment = 1;

    delete from movie_writer;
    alter table movie_writer auto_increment = 1;

    delete from movie_star;
    alter table movie_star auto_increment = 1;

    delete from movie_country;
    alter table movie_country auto_increment = 1;

    delete from movie_language;
    alter table movie_language auto_increment = 1;

    insert into movie (movie_id , title , `year` , rating , run_time , poster) values
        (1 , 'There Will Be Blood'                            , '2007' , 'R'  , '2h 38m' , 'https://m.media-amazon.com/images/M/MV5BMjAxODQ4MDU5NV5BMl5BanBnXkFtZTcwMDU4MjU1MQ@@._V1_QL75_UX190_CR0,0,190,281_.jpg'                                ),
        (2 , 'The Lighthouse'                                 , '2019' , 'R'  , '1h 49m' , 'https://m.media-amazon.com/images/M/MV5BZmE0MGJhNmYtOWNjYi00Njc5LWE2YjEtMWMxZTVmODUwMmMxXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_QL75_UX190_CR0,0,190,281_.jpg'),
        (3 , 'Killers of the Flower Moon'                     , '2023' , 'R'  , '3h 26m' , 'https://m.media-amazon.com/images/M/MV5BNjQwOGM2YTItMGYwNC00YTM4LWI0Y2QtZjQ2ZDcyMmRjMTFhXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_QL75_UX190_CR0,2,190,281_.jpg'),
        (4 , 'Pulp Fiction'                                   , '1994' , 'R'  , '2h 34m' , 'https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_QL75_UY281_CR2,0,190,281_.jpg'),
        (5 , 'Star Wars: Episode V - The Empire Strikes Back' , '1980' , 'PG' , '2h 4m'  , 'https://m.media-amazon.com/images/M/MV5BYmU1NDRjNDgtMzhiMi00NjZmLTg5NGItZDNiZjU5NTU4OTE0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_QL75_UX190_CR0,7,190,281_.jpg');

    insert into person (person_id , `name` , imageURL) values
        (1  , 'Paul Thomas Anderson' , 'imageURL'),
        (2  , 'Upton Sinclair'       , 'imageURL'),
        (3  , 'Daniel Day-Lewis'     , 'imageURL'),
        (4  , 'Paul Dano'            , 'imageURL'),
        (5  , 'Ciarán Hinds'         , 'imageURL'),
        (6  , 'Robert Eggers'        , 'imageURL'),
        (7  , 'Max Eggers'           , 'imageURL'),
        (8  , 'Robert Pattinson'     , 'imageURL'),
        (9  , 'Willem Dafoe'         , 'imageURL'),
        (10 , 'Valeriia Karaman'     , 'imageURL'),
        (11 , 'Martin Scorsese'      , 'imageURL'),
        (12 , 'Eric Roth'            , 'imageURL'),
        (13 , 'David Grann'          , 'imageURL'),
        (14 , 'Leonardo DiCaprio'    , 'imageURL'),
        (15 , 'Robert De Niro'       , 'imageURL'),
        (16 , 'Lily Gladstone'       , 'imageURL'),
        (17 , 'Quentin Tarantino'    , 'imageURL'),
        (18 , 'Roger Avary'          , 'imageURL'),
        (19 , 'John Travolta'        , 'imageURL'),
        (20 , 'Uma Thurman'          , 'imageURL'),
        (21 , 'Samuel L. Jackson'    , 'imageURL'),
        (22 , 'Irvin Kershner'       , 'imageURL'),
        (23 , 'Leigh Brackett'       , 'imageURL'),
        (24 , 'Lawrence Kasdan'      , 'imageURL'),
        (25 , 'George Lucas'         , 'imageURL'),
        (26 , 'Mark Hamill'          , 'imageURL'),
        (27 , 'Harrison Ford'        , 'imageURL'),
        (28 , 'Carrie Fisher'        , 'imageURL');

    insert into country (country_id , `name`) values
        (1 , 'United States'),
        (2 , 'Canada'       );

    insert into lang (language_id , `name`) values
        (1 , 'English'               ),
        (2 , 'American Sign Language'),
        (3 , 'Sioux'                 ),
        (4 , 'Latin'                 ),
        (5 , 'French'                ),
        (6 , 'Spanish'               );

    insert into movie_director (movie_id , director_id) values
        (1 , 1 ),
        (2 , 6 ),
        (3 , 11),
        (4 , 17),
        (5 , 22);

    insert into movie_writer (movie_id , writer_id) values
        (1 , 1 ),
        (1 , 2 ),
        (2 , 6 ),
        (2 , 7 ),
        (3 , 12),
        (3 , 11),
        (3 , 13),
        (4 , 17),
        (4 , 18),
        (5 , 23),
        (5 , 24),
        (5 , 25);

    insert into movie_star (movie_id , star_id) values
        (1 , 3 ),
        (1 , 4 ),
        (1 , 5 ),
        (2 , 8 ),
        (2 , 9 ),
        (2 , 10),
        (3 , 14),
        (3 , 15),
        (3 , 16),
        (4 , 19),
        (4 , 20),
        (4 , 21),
        (5 , 26),
        (5 , 27),
        (5 , 28);

    insert into movie_country (movie_id , country_id) values
        (1 , 1),
        (2 , 1),
        (2 , 2),
        (3 , 1),
        (4 , 1),
        (5 , 1);

    insert into movie_language (movie_id , language_id) values
        (1 , 1),
        (1 , 2),
        (2 , 1),
        (3 , 1),
        (3 , 3),
        (3 , 4),
        (3 , 5),
        (4 , 1),
        (4 , 6),
        (4 , 5),
        (5 , 1);
end //
delimiter ;