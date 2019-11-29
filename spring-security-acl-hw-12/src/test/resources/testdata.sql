insert into authors (name) values ('Пушкин А.С.');
insert into authors (name) values ('Лермонтов М.Ю.');
insert into authors (name) values ('Шарлотта Бронте');

insert into genres (name) values ('Сказка');
insert into genres (name) values ('Поэзия');
insert into genres (name) values ('Роман');

insert into books (name, author_id, genre_id) values ('Сказка о попе и о работнике его Балде', 1, 1);
insert into books (name, author_id, genre_id) values ('Сказка о золотом петушке', 1, 1);
insert into books (name, author_id, genre_id) values ('Руслан и Людмила', 1, 2);
insert into books (name, author_id, genre_id) values ('Евгений Онегин', 1, 3);

insert into books (name, author_id, genre_id) values ('Бородино', 2, 2);
insert into books (name, author_id, genre_id) values ('Парус', 2, 2);
insert into books (name, author_id, genre_id) values ('Герой нашего времени', 2, 3);

insert into books (name, author_id, genre_id) values ('Джейн Эйр', 3, 3);

insert into comments (text, book_id) values ('Концовка норм :)', 1);
insert into comments (text, book_id) values ('Один из лучших романов классической английской литературы.', 8);

insert into users (login, password) values ('user', '$2y$12$kEFfx0yBfPoi.ifh5UIVg.R8dV2HXkqNZQ07JbnFa6u08k.gjy0Zi');
insert into users (login, password) values ('admin', '$2y$12$CAfCUuPOludlZWC.0KER3.7DjdBVT0iL69UvabUJZM01WzhQF9/6O');

insert into roles (role) values ('USER');
insert into roles (role) values ('ADMIN');

insert into user_roles (user_id, role_id) values (1, 1);
insert into user_roles (user_id, role_id) values (2, 2);

INSERT INTO acl_sid (id, principal, sid) VALUES
(1, 0, 'ROLE_ADMIN'),
(2, 0, 'ROLE_USER');

INSERT INTO acl_class (id, class) VALUES
(1, 'me.kolganov.springsecurityaclhw12.domain.Author');

INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES
(1, 1, 1, NULL, 1, 0),--класс Author, id=1, ROLE_ADMIN
(2, 1, 2, NULL, 1, 0);--класс Author, id=2, ROLE_ADMIN

INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES
(1, 1, 1, 2, 2, 1, 1, 1),--разрешили ROLE_USER CREATE id=1 класса Author
(2, 2, 1, 2, 2, 1, 1, 1);--разрешили ROLE_USER CREATE id=2 класса Author