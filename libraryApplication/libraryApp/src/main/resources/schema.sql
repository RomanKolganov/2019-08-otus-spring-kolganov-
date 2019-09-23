drop table if exists authors;
drop table if exists books;
drop table if exists genres;

create table authors(
    id bigserial,
    name varchar(500),
    primary key (id)
);

create table genres(
    id bigserial,
    name varchar(500),
    primary key (id)
);

create table books(
    id bigserial,
    name varchar(500),
    author_id bigint references authors (id),
    genre_id bigint references genres (id),
    primary key (id)
);