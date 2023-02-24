/*
 * 	TBL_OWNER
	-------------------------------------------------
	OWNER_ID		NUMBER PK_OWNER
	--------------------------------------------------
	OWNER_NAME		VARCHAR2 NOT NULL
	OWNER_AGE		NUMBER
	OWNER_ADDRESS	VARCHAR2 NOT NULL
	OWNER_PHONE		VARCHAR2 NOT NULL

 * */

DROP TABLE TBL_OWNER;

CREATE TABLE TBL_OWNER(
	OWNER_ID NUMBER CONSTRAINT PK_PET PRIMARY KEY,
	OWNER_NAME VARCHAR2(500) NOT NULL,
	OWNER_AGE NUMBER,
	OWNER_ADDRESS VARCHAR2(500) NOT NULL,
	OWNER_PHONE VARCHAR2(500) NOT NULL
);

ALTER TABLE TBL_OWNER RENAME CONSTRAINT PK_PET TO PK_OWNER;
/*
 * 
	TBL_PET
	-------------------------------------------------
	PET_ID		NUMBER PK_PET
	------------------------------------------------
	PET_NAME		VARCHAR2 NOT NULL
	PET_AGE		NUMBER NOT NULL
	PET_ILL_NAME	VARCHAR2 NOT NULL
	OWNER_ID		NUMBER FK_PET_OWNER
 * */



CREATE TABLE TBL_PET (
	PET_ID NUMBER CONSTRAINT PK_PET PRIMARY KEY,
	PET_TYPE VARCHAR2(500) NOT NULL,
	PET_NAME VARCHAR2(500) NOT NULL,
	PET_AGE NUMBER NOT NULL,
	PET_ILL_NAME VARCHAR2(500) NOT NULL,
	OWNER_ID NUMBER,
	CONSTRAINT FK_PET_OWNER FOREIGN KEY(OWNER_ID) REFERENCES TBL_OWNER(OWNER_ID)
);

/* TBL_ANIMAL */
CREATE SEQUENCE SEQ_ANIMAL;

SELECT *  FROM TBL_ANIMAL;

INSERT INTO TBL_ANIMAL (ANIMAL_ID, ANIMAL_TYPE, ANIMAL_AGE, ANIMAL_FEED)
VALUES(SEQ_ANIMAL.NEXTVAL, '개', 10, '사료');

INSERT INTO TBL_ANIMAL (ANIMAL_ID, ANIMAL_TYPE, ANIMAL_AGE, ANIMAL_FEED)
VALUES(SEQ_ANIMAL.NEXTVAL, '고양이', 5, '사료');

UPDATE TBL_ANIMAL
SET ANIMAL_TYPE = '고양이'
WHERE ANIMAL_ID = 1;

DELETE FROM TBL_ANIMAL WHERE ANIMAL_TYPE = '게';

DROP TABLE TBL_ANIMAL;
DROP SEQUENCE SEQ_ANIMAL;



/* TBL_STUDENT */
CREATE SEQUENCE SEQ_STUDENT;

SELECT * FROM TBL_STUDENT;

INSERT INTO TBL_STUDENT
(STUDENT_ID, STUDENT_IDENTIFICATION, STUDENT_NAME, STUDENT_MAJOR, STUDENT_GENDER, STUDENT_BIRTH, STUDENT_AGE, STUDENT_GRADE)
VALUES(SEQ_STUDENT.NEXTVAL, 'doeunnkimm', '김도은', '컴퓨터', 'N', '2002-02-23', 23, 'A+');

INSERT INTO TBL_STUDENT
(STUDENT_ID, STUDENT_IDENTIFICATION, STUDENT_NAME, STUDENT_MAJOR, STUDENT_BIRTH, STUDENT_AGE, STUDENT_GRADE)
VALUES(SEQ_STUDENT.NEXTVAL, 'gildonghong', '홍길동', '컴퓨터', '2002-02-23', 23, 'A+');


UPDATE TBL_STUDENT 
SET STUDENT_MAJOR = '소프트웨어'
WHERE STUDENT_IDENTIFICATION = 'gildonghong';

DELETE FROM TBL_STUDENT
WHERE STUDENT_ID = 2;


/* TBL_FLOWER */
SELECT * FROM TBL_FLOWER;

INSERT INTO TBL_FLOWER
(FLOWER_NAME, FLOWER_COLOR, FLOWER_PRICE)
VALUES('장미', '빨간색', 5000);

INSERT INTO TBL_FLOWER
(FLOWER_NAME, FLOWER_COLOR, FLOWER_PRICE)
VALUES('장미', '노란색', 5000);

INSERT INTO TBL_FLOWER
(FLOWER_NAME, FLOWER_COLOR, FLOWER_PRICE)
VALUES('국화', '노란색', 4000);

UPDATE TBL_FLOWER 
SET FLOWER_NAME = '해바라기'
WHERE FLOWER_NAME = '장미' AND FLOWER_COLOR = '노란색' ;

/* 
 * 02292: integrity constraint (HR.FK_POT) violated - child record found 
 * -> 참조하고 있는 부모를 수정, 삭제를 할 때에는 자식에서 참조하고 있는지를 확인하고
 * 				자식을 먼저 수정하거나 삭제하고 해야 함
 * */
UPDATE TBL_FLOWER 
SET FLOWER_NAME = '국화'
WHERE FLOWER_NAME = '해바라기' AND FLOWER_COLOR = '노란색' ;


/* TBL_POT */
CREATE SEQUENCE SEQ_POT;

SELECT * FROM TBL_POT;

INSERT INTO TBL_POT
(POT_ID, POT_SHAPE, POT_COLOR, FLOWER_NAME, FLOWER_COLOR)
VALUES(SEQ_POT.NEXTVAL , '원기둥', '흰색', '해바라기', '노란색');




CREATE SEQUENCE SEQ_OWNER;
CREATE SEQUENCE SEQ_PET;

/* 정보 조회 */
SELECT * FROM TBL_OWNER;
SELECT * FROM TBL_PET;

/* 정보 추가 */
INSERT INTO TBL_OWNER
(OWNER_ID, OWNER_NAME, OWNER_AGE, OWNER_ADDRESS, OWNER_PHONE)
VALUES(SEQ_OWNER.NEXTVAL , '김도은', 23, '경기도', '010-1234-1234');

INSERT INTO TBL_OWNER
(OWNER_ID, OWNER_NAME, OWNER_AGE, OWNER_ADDRESS, OWNER_PHONE)
VALUES(SEQ_OWNER.NEXTVAL , '홍길동', 25, '서울', '010-2222-3333');

/* 정보 수정 : 보호자 이름 변경 */
UPDATE TBL_OWNER 
SET OWNER_NAME = '이순신'
WHERE OWNER_NAME = '김도은';

/* 동일한 보호자의 반려 동물 추가 */
INSERT INTO TBL_PET
(PET_ID, PET_TYPE, PET_NAME, PET_AGE, PET_ILL_NAME, OWNER_ID)
VALUES(SEQ_PET.NEXTVAL , '말티즈', '뽀삐', 5, '감기', 1);

INSERT INTO TBL_PET
(PET_ID, PET_TYPE, PET_NAME, PET_AGE, PET_ILL_NAME, OWNER_ID)
VALUES(SEQ_PET.NEXTVAL , '고양이', '나비', 1, '배탈', 1);

INSERT INTO TBL_PET
(PET_ID, PET_TYPE, PET_NAME, PET_AGE, PET_ILL_NAME, OWNER_ID)
VALUES(SEQ_PET.NEXTVAL , '고양이', '톰', 2, '방광염', 2);

INSERT INTO TBL_PET
(PET_ID, PET_TYPE, PET_NAME, PET_AGE, PET_ILL_NAME, OWNER_ID)
VALUES(SEQ_PET.NEXTVAL , '고양이', '잭', 2, '눈병', 2);

/* 반려 동물을 키우고 있는 보호자를 변원 보호자 명단에서 삭제 */
UPDATE TBL_PET
SET OWNER_ID = NULL 
WHERE OWNER_ID IS NOT NULL;

UPDATE TBL_PET
SET OWNER_ID = 1 
WHERE OWNER_ID IS NULL;

UPDATE TBL_PET 
SET OWNER_ID = 2
WHERE PET_TYPE = '고양이';


/* 두 마리 이상의 반려동물 보호자의 핸드폰 번호를 다른 번호로 변경 */
UPDATE TBL_OWNER 
SET OWNER_PHONE = '010-6666-7777'
WHERE OWNER_ID  = 
(
	SELECT OWNER_ID  FROM TBL_PET
	GROUP BY OWNER_ID 
	HAVING COUNT(OWNER_ID) >= 2
);

/*DML 실습*/
/*PLAYER 테이블에서 TEAM_ID가 'K01'인 선수*/
SELECT * FROM PLAYER
WHERE TEAM_ID = 'K01';

/*PLAYER 테이블에서 TEAM_ID가 'K01'이 아닌 선수*/
SELECT * FROM PLAYER
WHERE TEAM_ID != 'K01';

/*PLAYER 테이블에서 WEIGHT가 70이상이고 80이하인 선수*/
SELECT * FROM PLAYER
WHERE WEIGHT BETWEEN 70 AND 80;

/*PLAYER 테이블에서 TEAM_ID가 'K03'이고 HEIGHT가 180미만인 선수*/
SELECT * FROM PLAYER
WHERE TEAM_ID = 'K03' AND HEIGHT < 180;

/*PLAYER 테이블에서 TEAM_ID가 'K06'이고 NICKNAME이 '제리'인 선수*/
SELECT * FROM PLAYER
WHERE TEAM_ID = 'K06' AND NICKNAME = '제리';

/*PLAYER 테이블에서 HEIGHT가 170이상이고 WEIGHT가 80이상인 선수 이름*/
SELECT * FROM PLAYER
WHERE HEIGHT >= 170 AND WEIGHT >= 80;

/*STADIUM 테이블에서 SEAT_COUNT가 30000 초과이고 41000이하인 경기장*/
SELECT * FROM STADIUM
WHERE SEAT_COUNT > 30000 AND SEAT_COUNT <= 41000;

/*PLAYER 테이블에서 TEAM_ID가 'K02'이거나 'K07'이고 포지션은 'MF'인 선수*/
SELECT * FROM PLAYER
WHERE (TEAM_ID = 'K02' OR TEAM_ID = 'K07') AND "POSITION" = 'MF';

SELECT * FROM PLAYER
WHERE TEAM_ID IN ('K02', 'K07') AND "POSITION" = 'MF';
























