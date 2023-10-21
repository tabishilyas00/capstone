drop database if exists devflix;
create database devflix;
use devflix;

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

create table country (
    country_id int primary key auto_increment,
    `name` varchar(25) not null
);

create table lang (
    language_id int primary key auto_increment,
    `name` varchar(25) not null
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