drop table if exists comments;
drop table if exists books;
drop table if exists authors;
drop table if exists genres;
drop table if exists user_roles;
drop table if exists users;
drop table if exists roles;
drop table if exists acl_entry;
drop table if exists acl_object_identity;
drop table if exists acl_sid;
drop table if exists acl_class;

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

CREATE TABLE IF NOT EXISTS users (
    id bigserial,
    login varchar(500),
    password varchar(500),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS roles (
    id bigserial,
    role varchar(500),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS user_roles (
    user_id bigint,
    role_id bigint
);

CREATE TABLE IF NOT EXISTS acl_sid (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  principal tinyint(1) NOT NULL,
  sid varchar(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY unique_uk_1 (sid,principal)
);

CREATE TABLE IF NOT EXISTS acl_class (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  class varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY unique_uk_2 (class)
);

CREATE TABLE IF NOT EXISTS acl_entry (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  acl_object_identity bigint(20) NOT NULL,
  ace_order int(11) NOT NULL,
  sid bigint(20) NOT NULL,
  mask int(11) NOT NULL,
  granting tinyint(1) NOT NULL,
  audit_success tinyint(1) NOT NULL,
  audit_failure tinyint(1) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY unique_uk_4 (acl_object_identity,ace_order)
);

CREATE TABLE IF NOT EXISTS acl_object_identity (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  object_id_class bigint(20) NOT NULL,
  object_id_identity bigint(20) NOT NULL,
  parent_object bigint(20) DEFAULT NULL,
  owner_sid bigint(20) DEFAULT NULL,
  entries_inheriting tinyint(1) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY unique_uk_3 (object_id_class,object_id_identity)
);

ALTER TABLE acl_entry
ADD FOREIGN KEY (acl_object_identity) REFERENCES acl_object_identity(id);

ALTER TABLE acl_entry
ADD FOREIGN KEY (sid) REFERENCES acl_sid(id);

--
-- Constraints for table acl_object_identity
--
ALTER TABLE acl_object_identity
ADD FOREIGN KEY (parent_object) REFERENCES acl_object_identity (id);

ALTER TABLE acl_object_identity
ADD FOREIGN KEY (object_id_class) REFERENCES acl_class (id);

ALTER TABLE acl_object_identity
ADD FOREIGN KEY (owner_sid) REFERENCES acl_sid (id);

--postgres acl tables
--create table acl_sid(
--	id bigserial not null primary key,
--	principal boolean not null,
--	sid varchar(100) not null,
--	constraint unique_uk_1 unique(sid,principal)
--);
--
--create table acl_class(
--	id bigserial not null primary key,
--	class varchar(100) not null,
--	constraint unique_uk_2 unique(class)
--);
--
--create table acl_object_identity(
--	id bigserial primary key,
--	object_id_class bigint not null,
--	object_id_identity bigint not null,
--	parent_object bigint,
--	owner_sid bigint,
--	entries_inheriting boolean not null,
--	constraint unique_uk_3 unique(object_id_class,object_id_identity),
--	constraint foreign_fk_1 foreign key(parent_object)references acl_object_identity(id),
--	constraint foreign_fk_2 foreign key(object_id_class)references acl_class(id),
--	constraint foreign_fk_3 foreign key(owner_sid)references acl_sid(id)
--);
--
--create table acl_entry(
--	id bigserial primary key,
--	acl_object_identity bigint not null,
--	ace_order int not null,
--	sid bigint not null,
--	mask integer not null,
--	granting boolean not null,
--	audit_success boolean not null,
--	audit_failure boolean not null,
--	constraint unique_uk_4 unique(acl_object_identity,ace_order),
--	constraint foreign_fk_4 foreign key(acl_object_identity) references acl_object_identity(id),
--	constraint foreign_fk_5 foreign key(sid) references acl_sid(id)
--);