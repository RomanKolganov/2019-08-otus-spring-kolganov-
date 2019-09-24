insert into authors (`name`) values ('Пушкин А.С.');
insert into authors (`name`) values ('Лермонтов М.Ю.');

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