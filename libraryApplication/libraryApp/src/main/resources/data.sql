insert into authors (`name`) values ('Пушкин А.С.');
insert into authors (`name`) values ('Лермонтов М.Ю.');

insert into genres (`name`) values ('Сказка');
insert into genres (`name`) values ('Поэзия');

insert into books (`name`, author_id, genre_id) values ('Сказка о попе и о работнике его Балде', 1, 1);
