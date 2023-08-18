/* 全テーブル削除 */
drop table follows if exists;
drop table posts if exists;
drop table users if exists;

/* データ作成 */
/* user */
create table users (
	id varchar(100) primary key,
	name varchar(100) not null,
	email varchar(100) not null unique,
	password varchar(100) not null,
	selfDescription varchar(500),
	avatarFileName varchar(100),
	homeImageFileName varchar(100)
);

insert into users (id, name, email, password, selfDescription, avatarFileName, homeImageFileName) values('@user', 'user', 'user@email.com', 'pass', '自己紹介', '@user_2023-08-08_22-46-20.jpg', '');
insert into users (id, name, email, password, selfDescription, avatarFileName, homeImageFileName) values('@user2', 'user2', 'user2@email.com', 'pass', '', '', '');
insert into users (id, name, email, password, selfDescription, avatarFileName, homeImageFileName) values('@user3', 'user3', 'user3@email.com', 'pass', '', '', '');

/* post */
create table posts(
	id int auto_increment primary key,
	text varchar(500) not null,
	created_at timestamp not null,
	user_id varchar(100) not null,
	reply_to_id int,
	foreign key(user_id) references users(id),
	foreign key(reply_to_id) references posts(id)
);

insert into posts(text, created_at, user_id) values ('test text', '2023-7-17 8:29:00', '@user');
insert into posts(text, created_at, user_id) values ('test text user 2-1', '2023-7-14 8:29:00', '@user2');
insert into posts(text, created_at, user_id) values ('test text user 2-2', '2023-7-15 8:29:00', '@user2');
insert into posts(text, created_at, user_id) values ('test text user 2-4', '2023-7-17 8:29:00', '@user2');
insert into posts(text, created_at, user_id) values ('米CPIは市場予想を小幅に下回りました。市場に安心感が広がり、米国株は上昇しています。昨日まで株価はやや調整色が出ていたこともあり、自律的なリバウンドという面もありそうです。日経平均先物も上昇しています。一方、為替はCPIの反応は一時的で、その後、144円台へと円安が進んでいます', '2023-7-16 8:29:00', '@user2');
insert into posts(text, created_at, user_id, reply_to_id) values ('リプライ', '2023-4-17 8:29:00', '@user',2);
insert into posts(text, created_at, user_id, reply_to_id) values ('リプライ2', '2023-5-17 8:29:00', '@user',2);
insert into posts(text, created_at, user_id, reply_to_id) values ('リプライ3', '2023-6-17 8:29:00', '@user3',2);
insert into posts(text, created_at, user_id, reply_to_id) values ('リプライ4', '2023-7-17 8:29:00', '@user3',2);

/* follow */
create table follows (
	id int auto_increment primary key,
	follower_id varchar(100) not null,
	followed_id varchar(100) not null,
	foreign key (follower_id) references users(id),
	foreign key (followed_id) references users(id)
);

insert into follows(follower_id, followed_id) values('@user', '@user2');