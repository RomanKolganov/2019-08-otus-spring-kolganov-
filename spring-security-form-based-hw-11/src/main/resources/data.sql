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
insert into roles (role) values ('user');
insert into user_roles(user_id, role_id) values (1, 1);