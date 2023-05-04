use app;

create table tbl_file(
	file_id int unsigned auto_increment primary key,
	file_system_name varchar(500),
	file_original_name varchar(500),
	file_size bigint unsigned,
	board_id int unsigned,
	constraint fk_file_board foreign key(board_id)
	references tbl_board(board_id)
);

select * from tbl_file;