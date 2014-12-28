DROP TABLE ent_board;
DROP TABLE modification_time;

CREATE TABLE ent_board(
	board_no INT AUTO_INCREMENT NOT NULL,
	email VARCHAR(100) NOT NULL,
	password VARCHAR(20) NOT NULL,
	createtime DATETIME DEFAULT SYSDATETIME,
	attachment BLOB,
	body STRING NOT NULL,
	PRIMARY KEY(board_no)
);

CREATE TABLE modification_time(
	board_no INT NOT NULL,
	modification_time DATETIME DEFAULT SYSDATETIME,	
	PRIMARY KEY(board_no),
	FOREIGN KEY (board_no) REFERENCES ent_board (board_no)
);
