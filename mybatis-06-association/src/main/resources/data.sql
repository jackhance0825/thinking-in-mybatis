CREATE TABLE student(
	`id` INT(20) NOT NULL PRIMARY KEY,
	`name` VARCHAR(30) DEFAULT NULL,
	tid INT(20) NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE teacher(
	tid INT(20) NOT NULL PRIMARY KEY,
	`name` VARCHAR(30) DEFAULT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;


INSERT INTO teacher(tid, `name`) VALUES(1, "张老师");


INSERT INTO student(`id`, `name`, tid) VALUES
(1, "张三", 1),
(2, "李四", 1),
(3, "王五", 1),
(4, "王六", 1),
(5, "王奇", 1)
;