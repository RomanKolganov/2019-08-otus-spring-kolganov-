insert into authors (`name`) values ('Пушкин А.С.');
insert into authors (`name`) values ('Лермонтов М.Ю.');
insert into authors (`name`) values ('Шарлотта Бронте');

insert into genres (`name`) values ('Сказка');
insert into genres (`name`) values ('Поэзия');
insert into genres (`name`) values ('Роман');

insert into books (`name`, author_id, genre_id) values ('Сказка о попе и о работнике его Балде', 1, 1);
insert into books (`name`, author_id, genre_id) values ('Сказка о золотом петушке', 1, 1);
insert into books (`name`, author_id, genre_id) values ('Руслан и Людмила', 1, 2);
insert into books (`name`, author_id, genre_id) values ('Евгений Онегин', 1, 3);

insert into books (`name`, author_id, genre_id) values ('Бородино', 2, 2);
insert into books (`name`, author_id, genre_id) values ('Парус', 2, 2);
insert into books (`name`, author_id, genre_id) values ('Герой нашего времени', 2, 3);

insert into books (`name`, author_id, genre_id) values ('Джейн Эйр', 3, 3);

insert into comments (text, book_id) values ('Концовка норм :)', 1);
insert into comments (text, book_id) values ('Один из лучших романов классической английской литературы.', 8);

insert into users (login, password) values ('user', '$2y$12$kEFfx0yBfPoi.ifh5UIVg.R8dV2HXkqNZQ07JbnFa6u08k.gjy0Zi');
insert into users (login, password) values ('admin', '$2y$12$CAfCUuPOludlZWC.0KER3.7DjdBVT0iL69UvabUJZM01WzhQF9/6O');

insert into roles (role) values ('USER');
insert into roles (role) values ('ADMIN');

insert into user_roles (user_id, role_id) values (1, 1);
insert into user_roles (user_id, role_id) values (2, 2);

insert into acl_sid (id, principal, sid) values
(1, 1, 'ADMIN'),
(2, 1, 'USER'),
(3, 0, 'SOMEONE');

insert into acl_class (id, class) values
(1, 'me.kolganov.springsecurityaclhw12.domain.Author');

insert into acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) values
(1, 1, 1, NULL, 3, 0),
(2, 1, 2, NULL, 3, 0),
(3, 1, 3, NULL, 3, 0);

insert into acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) values
(1, 1, 1, 1, 1, 1, 1, 1),
(2, 1, 2, 1, 2, 1, 1, 1),
(3, 1, 3, 3, 1, 1, 1, 1),
(4, 2, 1, 2, 1, 1, 1, 1),
(5, 2, 2, 3, 1, 1, 1, 1),
(6, 3, 1, 3, 1, 1, 1, 1),
(7, 3, 2, 3, 2, 1, 1, 1);