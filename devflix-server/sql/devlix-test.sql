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

delimiter //
create procedure set_known_good_state()
begin
	delete from movie;
    alter table movie auto_increment = 1;

    insert into movie (movie_id , title , `year` , rating , run_time , poster) values
        (1 , 'There Will Be Blood'                            , '2007' , 'R'  , '2h 38m' , 'https://m.media-amazon.com/images/M/MV5BMjAxODQ4MDU5NV5BMl5BanBnXkFtZTcwMDU4MjU1MQ@@._V1_QL75_UX190_CR0,0,190,281_.jpg'                                ),
        (2 , 'The Lighthouse'                                 , '2019' , 'R'  , '1h 49m' , 'https://m.media-amazon.com/images/M/MV5BZmE0MGJhNmYtOWNjYi00Njc5LWE2YjEtMWMxZTVmODUwMmMxXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_QL75_UX190_CR0,0,190,281_.jpg'),
        (3 , 'Killers of the Flower Moon'                     , '2023' , 'R'  , '3h 26m' , 'https://m.media-amazon.com/images/M/MV5BNjQwOGM2YTItMGYwNC00YTM4LWI0Y2QtZjQ2ZDcyMmRjMTFhXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_QL75_UX190_CR0,2,190,281_.jpg'),
        (4 , 'Pulp Fiction'                                   , '1994' , 'R'  , '2h 34m' , 'https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_QL75_UY281_CR2,0,190,281_.jpg'),
        (5 , 'Star Wars: Episode V - The Empire Strikes Back' , '1980' , 'PG' , '2h 4m'  , 'https://m.media-amazon.com/images/M/MV5BYmU1NDRjNDgtMzhiMi00NjZmLTg5NGItZDNiZjU5NTU4OTE0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_QL75_UX190_CR0,7,190,281_.jpg');
end //
delimiter ;