SET FOREIGN_KEY_CHECKS=0;
drop table if exists teachers;
create table teachers(
 id int auto_increment primary key,
 name varchar(20) not null,
 email varchar(20) not null unique,
 password varchar(20),
 phone varchar(20),
 duty  varchar(20),
 age int,
 status tinyint
);
insert into teachers(name,email,password,phone,duty,status) 
              values('admin','admin@qdsoft.com','111111','13953212345','教授',1);
drop table if exists subjects;
create table  subjects(
id int auto_increment primary key,
name varchar(20) not null,
score int
);
insert into subjects(id,name,score) values(1,'java程序设计',3);

drop table if exists items;
create table items(
 id int auto_increment primary key,
 title  varchar(32) not null,
 correct tinyint,
 qid  int ,
 constraint foreign key (qid) references questions(id)
);

drop table if exists questions;
create table questions(
 id int auto_increment primary key,
 title varchar(60),
 type tinyint,
 subid int,
 tid int,
 status tinyint,
 constraint foreign key (subid) references subjects(id),
 constraint foreign key (tid) references teachers(id)
);