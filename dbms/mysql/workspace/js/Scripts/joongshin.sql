CREATE database js;
use js;


CREATE table tbl_user(
	user_id int unsigned auto_increment primary key,
	user_email varchar(500) not null unique,
	user_password varchar(500) not null,
	user_name varchar(500) not null unique,
	user_address varchar(500) not null,
	user_phonenumber varchar(500) not null
);

alter table tbl_user add column user_profile_image varchar(1000) default "default.png";

alter table tbl_user alter column user_profile_image set default "default.svg";

select * from tbl_user;

INSERT INTO js.tbl_user
(user_email, user_password, user_name, user_address, user_phonenumber)
VALUES('test@test.com', 'kyj1111!!!!', '김도은3', '서울시 강남구', '01011112222');

select user_password from tbl_user where user_id = 4;

select *
from tbl_user
where user_id = 5;

update tbl_user
set user_name = "김도은(변경)"
where user_id = 1

update tbl_user
set user_password = '1111'
where user_id = 1

delete from tbl_user
where user_id = 1;

CREATE table tbl_junior_user(
	user_id int unsigned primary key,
	user_career_years int,
	user_resume varchar(500),
	constraint fk_junior_user foreign key(user_id)
	references tbl_user(user_id) on delete cascade
);

select count(user_id) 
from tbl_junior_user
where user_id = 14

select * from tbl_junior_user

select * from tbl_junior_user where user_id = 14

INSERT INTO js.tbl_junior_user
(user_id, user_career_years, user_resume)
VALUES(23, 3, '이력서 테스트중입니다!!!');

update tbl_junior_user
set user_resume = "수정된 이력서입니다.", user_career_years = 2
where user_id = 14

select user_id, user_career_years, user_resume
from tbl_junior_user
where user_id = 14;


CREATE table tbl_admin_user(
	user_id int unsigned primary key,
	admin_permission_level tinyint default 1,
	constraint fk_admin_user foreign key(user_id)
	references tbl_user(user_id) on delete cascade
);

CREATE table tbl_board(
	board_id int unsigned auto_increment primary key,
	user_id int unsigned not null,
	board_title varchar(500) not null,
	board_content varchar(1000) not null,
	board_type char(2) not null check(board_type in('구인', '구직', '문의')),
	constraint fk_board_user foreign key(user_id)
	references tbl_user(user_id) on delete cascade
);

INSERT INTO js.tbl_board
(user_id, board_title, board_content, board_type, board_status, board_register_date)
VALUES(20, '테스트 제목입니다', '테스트 내용입니다', '구인', null, CURRENT_TIMESTAMP);

select * from tbl_board;

alter table tbl_board add board_status varchar (500);

alter table tbl_board add board_register_date datetime default current_timestamp;

select * from tbl_board;

CREATE table tbl_board_tag(
	tag_id int unsigned auto_increment primary key,
	board_id int unsigned not null,
	tag_name varchar(500),
	constraint fk_board_tag foreign key(board_id)
	references tbl_board(board_id) on delete cascade
);

CREATE table tbl_board_attachment_file(
	tag_id int unsigned auto_increment primary key,
	board_id int unsigned not null,
	file_name varchar(500) not null,
	file_origin_name varchar(500) not null,
	file_size int not null,
	file_image varchar(500),
	constraint fk_board_attachment_file foreign key(board_id)
	references tbl_board(board_id) on delete cascade
);

alter table tbl_board_attachment_file change tag_id board_file_id int unsigned auto_increment

select * from tbl_board_attachment_file tbaf 

CREATE table tbl_recommend(
	rec_id int unsigned auto_increment primary key,
	board_id int unsigned not null,
	user_id int unsigned not null,
	constraint fk_board_recommend foreign key(board_id)
	references tbl_board(board_id) on delete cascade,
	constraint fk_comment_recommend foreign key(user_id)
	references tbl_comment(user_id) on delete cascade
);

CREATE table tbl_message(
	message_id int unsigned auto_increment primary key,
	send_user_id int unsigned not null,
	recieve_user_id int unsigned not null,
	message_contents varchar(1000),
	constraint fk_send_user_id foreign key(send_user_id)
	references tbl_user(user_id) on delete cascade,
	constraint fk_recieve_user_id foreign key(recieve_user_id)
	references tbl_user(user_id) on delete cascade
);

CREATE table tbl_comment(
	comment_id int unsigned auto_increment primary key,
	board_id int unsigned not null,
	user_id int unsigned not null,
	comment_comments varchar(2000) not null,
	comment_register_date datetime default current_timestamp(),
	constraint fk_board_recommendation foreign key(board_id)
	references tbl_board(board_id) on delete cascade,
	constraint fk_user_recommendation foreign key(user_id)
	references tbl_user(user_id) on delete cascade
);

INSERT INTO js.tbl_comment
(board_id, user_id, comment_comments, comment_register_date)
VALUES(10, 16 , '테스트 댓글입니다', CURRENT_TIMESTAMP);

alter table tbl_comment add comment_contents varchar(2000) not null;
alter table tbl_comment change comment_contents comment_comments varchar(2000) not null;

alter table tbl_comment add comment_register_date datetime default current_timestamp();

select * from tbl_comment;

select c.board_id, c.user_id, comment_comments, board_title, comment_register_date
from tbl_board b join tbl_comment c
on b.board_id = c.board_id and c.user_id = 1;

INSERT INTO js.tbl_comment
(board_id, user_id, comment_comments, comment_register_date)
VALUES(10, 1, '테스트 댓글입니다', CURRENT_TIMESTAMP);

truncate tbl_comment;  

INSERT INTO js.tbl_user
(user_email, user_password, user_name, user_address, user_phonenumber)
VALUES('doeunnkimm2', '1234', '김도은2', '서울 강남구', '01011112222');

select * from tbl_user;

select board_id, u.user_id, board_title, board_content, board_type, user_name 
from tbl_user u join tbl_board b
on u.user_id = b.user_id and u.user_id = 1;

INSERT INTO js.tbl_board
(user_id, board_title, board_content, board_type)
VALUES(1, '테스트입니다', '테스트 내용입니다.', '구인');

create table tbl_junior_resume_file (
	file_id int unsigned auto_increment primary key,
	file_system_name varchar(500),
	file_original_name varchar(500),
	file_size bigint unsigned,
	user_id int unsigned,
	constraint fk_file_resume foreign key(user_id)
	references tbl_user(user_id)
);