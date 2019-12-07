drop table if exists comments;
drop table if exists books;
drop table if exists authors;
drop table if exists genres;

CREATE TABLE IF NOT EXISTS authors (
    id bigserial,
    name varchar(500),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS genres (
    id bigserial,
    name varchar(500),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS books (
    id bigserial,
    name varchar(500),
    author_id bigint references authors (id),
    genre_id bigint references genres (id),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS comments (
    id bigserial,
    text varchar(500),
    book_id bigint references books (id),
    primary key (id)
);