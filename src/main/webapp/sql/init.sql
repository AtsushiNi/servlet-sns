/* 全テーブル削除 */
drop table follow if exists;
drop table post if exists;
drop table "user" if exists;

/* データ作成 */
/* user */
create table "user" (
	id int auto_increment primary key,
	name varchar(100) not null,
	email varchar(100) not null unique,
	password varchar(100) not null
);

insert into "user" (name, email, password) values('user', 'user@email.com', 'pass');
insert into "user" (name, email, password) values('user2', 'user2@email.com', 'pass');
insert into "user" (name, email, password) values('user3', 'user3@email.com', 'pass');

/* post */
create table post(
	id int auto_increment primary key,
	text varchar(500) not null,
	created_at timestamp not null,
	user_id int not null,
	foreign key(user_id) references "user"(id)
);

insert into post(text, created_at, user_id) values ('test text', '2023-7-17 8:29:00', 1);
insert into post(text, created_at, user_id) values ('test text user 2-1', '2023-7-14 8:29:00', 2);
insert into post(text, created_at, user_id) values ('test text user 2-2', '2023-7-15 8:29:00', 2);
insert into post(text, created_at, user_id) values ('test text user 2-4', '2023-7-17 8:29:00', 2);
insert into post(text, created_at, user_id) values ('test text user 2-3', '2023-7-16 8:29:00', 2);

/* follow */
create table follow (
	id int auto_increment primary key,
	follower_id int not null,
	followed_id int not null,
	foreign key (follower_id) references "user"(id),
	foreign key (followed_id) references "user"(id)
);

insert into follow(follower_id, followed_id) values(1,2);