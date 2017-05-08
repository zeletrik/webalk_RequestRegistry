CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  zip int(11) NOT NULL ,
  city VARCHAR(60) NOT NULL ,
  street VARCHAR(60) NOT NULL ,
  streetno VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));

CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
  
  CREATE TABLE requests(
  id int(11) NOT NULL AUTO_INCREMENT,
  user varchar(45) NOT NULL,
  reviewer varchar(45) NOT NULL,
  template varchar(45) NOT NULL,
  status varchar(45) NOT NULL,
  motivate varchar(45) NOT NULL,
  PRIMARY KEY (id));
  
CREATE TABLE templates(
  title varchar(45) NOT NULL,
  destination varchar(45) NOT NULL,
  motivation TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (title));

INSERT INTO users(username,password,zip,city,street,streetno,enabled)
VALUES ('user','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.',3530,'Miskolc','Teszt utca','11/B', true);
INSERT INTO users(username,password,zip,city,street,streetno,enabled)
VALUES ('admin','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.',3700,'Kbarcika','Alma utca','3/G', true);
INSERT INTO users(username,password,zip,city,street,streetno,enabled)
VALUES ('teacher','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.',3530,'Miskolc','Egyetemvaros','1', true);

INSERT INTO user_roles (username, role)
VALUES ('user', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('admin', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('admin', 'ROLE_TEACHER');
INSERT INTO user_roles (username, role)
VALUES ('teacher', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('teacher', 'ROLE_TEACHER');

INSERT INTO templates(title,destination,motivation)
VALUES ('Rektori kerveny', 'Rektor', true);

INSERT INTO requests(id,user,reviewer,template,status,motivate)
VALUES (1,'user', 'teacher', 'Rektori kerveny','sent','Blablablab');