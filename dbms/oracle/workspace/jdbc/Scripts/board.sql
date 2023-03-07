CREATE SEQUENCE SEQ_BOARD;

CREATE TABLE TBL_BOARD(
   BOARD_ID NUMBER CONSTRAINT PK_BOARD PRIMARY KEY,
   BOARD_TITLE VARCHAR2(500) NOT NULL,
   BOARD_CONTENT VARCHAR2(1000) NOT NULL,
   BOARD_REGISTER_DATE DATE DEFAULT SYSDATE,
   BOARD_UPDATE_DATE DATE DEFAULT SYSDATE,
   USER_ID NUMBER NOT NULL,
   CONSTRAINT FK_BOARD_MEMBER FOREIGN KEY(USER_ID)
   REFERENCES TBL_USER(USER_ID) ON DELETE CASCADE
);

SELECT * FROM TBL_BOARD;