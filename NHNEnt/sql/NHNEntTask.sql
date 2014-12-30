DROP TABLE ent_board;

CREATE TABLE ent_board(
	board_no INT AUTO_INCREMENT NOT NULL,
	email VARCHAR(100) NOT NULL,
	password VARCHAR(20) NOT NULL,
	createtime DATETIME DEFAULT SYSDATETIME,
	modification_time DATETIME,	
	attachment BLOB,
	body STRING NOT NULL,
	PRIMARY KEY(board_no)
);

