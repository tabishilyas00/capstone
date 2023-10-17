drop database if exists devflix;
create database devflix;
use devflix;

create table movie (
    movie_id int primary key auto_increment,
    title varchar(50) not null,
    `year` varchar(4) not null,
    rating varchar(10) not null,
    run_time varchar(5) not null,
    poster varchar(1000) not null,
    country varchar(50) not null,
    `language` varchar(50) not null
);

create table director (
    director_id int primary key auto_increment,
    `name` varchar(50) not null,
    imageURL varchar(1000) null
);

create table writer (
    writer_id int primary key auto_increment,
    `name` varchar(50) not null,
    imageURL varchar(1000) null
);

create table actor (
    actor_id int primary key auto_increment,
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
        references director(director_id)
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
        references writer(writer_id)
);

create table movie_actor (
    movie_id int not null,
    actor_id int not null,
    constraint pk_movie_actor
        primary key (movie_id , actor_id),
    constraint fk_movie_actor_movie_id
        foreign key (movie_id)
        references movie(movie_id),
    constraint fk_movie_actor_actor_id
        foreign key (actor_id)
        references actor(actor_id)
);