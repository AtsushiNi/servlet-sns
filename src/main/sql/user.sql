drop table "user" if exists;

create table "user" (
	id int auto_increment primary key,
	name varchar(100) not null,
	email varchar(100) not null unique,
	password varchar(100) not null
);

insert into "user" (name, email, password) values('user', 'user@email.com', 'pass');
insert into "user" (name, email, password) values('user2', 'user2@email.com', 'pass');
insert into "user" (name, email, password) values('user3', 'user3@email.com', 'pass');
