DROP TABLE ent_board;
DROP TABLE ent_board_modi;

CREATE TABLE ent_board(
	board_no INT AUTO_INCREMENT NOT NULL,
	email VARCHAR(100) NOT NULL,
	password VARCHAR(20) NOT NULL,
	createtime DATETIME DEFAULT SYSDATETIME,
	data BLOB,
	body STRING NOT NULL,
	PRIMARY KEY(board_no)
);

CREATE TABLE ent_board_modi(
	board_no INT AUTO_INCREMENT NOT NULL,
	moditime DATETIME NOT NULL,	
	PRIMARY KEY(board_no),
	FOREIGN KEY (board_no) REFERENCES ent_board (board_no)
);
