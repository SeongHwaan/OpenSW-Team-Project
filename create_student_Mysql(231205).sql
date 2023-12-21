use webdb;

DROP TABLE student;

CREATE TABLE student (
    id INT NOT NULL Primary Key AUTO_INCREMENT,
    username VARCHAR(20),
    univ VARCHAR(40), #문자타입
    birth DATE, #날짜타입
    email VARCHAR(40)
);

INSERT INTO student(username, univ, birth, email) values('김길동','AA대학교','1999-10-21','kim@mail.com');
INSERT INTO student(username, univ, birth, email) values('아무개','BB대학교','2000-2-1','amg@kkk.com');
INSERT INTO student(username, univ, birth, email) values('김사랑','AA대학교','2000-3-15','ksr@kmail.com');
INSERT INTO student(username, univ, birth, email) values('김길동','CC대학교','2001-01-12','mol@bmail.com');
INSERT INTO student(username, univ, birth, email) values('이리와','BB대학교','2000-5-5','lee@nn.com');

SELECT * FROM student;