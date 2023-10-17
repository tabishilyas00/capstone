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
    director varchar(100),
    writer varchar(100),
    stars varchar(100),
    country varchar(50),
    `language` varchar(50)
);