CREATE TABLE IF NOT EXISTS authors (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(500),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS genres (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(500),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS books (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(500),
    author_id bigint references authors (id),
    genre_id bigint references genres (id),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS comments (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    text varchar(500),
    book_id bigint references books (id),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS users (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    login varchar(500),
    password varchar(500),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS roles (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    role varchar(500),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS user_roles (
    user_id bigint(20),
    role_id bigint(20)
);

--security acl tables
CREATE TABLE IF NOT EXISTS acl_class (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  class varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY unique_uk_2 (class)
);

CREATE TABLE IF NOT EXISTS acl_sid (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  sid varchar(100) NOT NULL,
  principal tinyint(1) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY unique_uk_1 (sid,principal)
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