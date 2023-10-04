# javaSemiProject
CINEMA : 영화관을 생각하여 JDBC를 기반으로 관리자모드 유저모드 나누어 구현한 개인 프로젝트



CINEMA테이블 

---------------------------------------------------유저테이블----------------------------------------------------
create table cinema_user(
    user_no number primary key,
    user_name varchar2(20) not null,
    USER_ID VARCHAR2(30) NOT NULL UNIQUE,
    USER_PWD VARCHAR2(30) NOT NULL,
    USER_AGE NUMBER,
    USER_GRADE VARCHAR2(10) not null,
    CHECK(USER_GRADE IN('USER', 'MANGER', 'BOSS')),
    STATUS VARCHAR2(10) DEFAULT 'NO' NOT NULL ,
    CHECK(STATUS IN('NO', 'YSE')),
    CHECKED VARCHAR2(10) DEFAULT 'NO'
    CHECK(CHECKED IN('NO', 'YSE'))
);

CREATE SEQUENCE SEQ_USER
NOCYCLE;
select * from cinema_user;
INSERT INTO user VALUES(SEQ_USER.NEXTVAL,'차정석','kil15978','kil79518',25,'BOSS',DEFAULT,DEFAULT);
INSERT INTO user VALUES(SEQ_USER.NEXTVAL,'지온유','USER02','USER02',18,'USER',DEFAULT,DEFAULT);
INSERT INTO user VALUES(SEQ_USER.NEXTVAL,'은수연','USER03','USER04',20,'USER',DEFAULT,'YSE');
INSERT INTO user VALUES(SEQ_USER.NEXTVAL,'오태경','USER04','USER05',24,'MANGER',DEFAULT,DEFAULT);
INSERT INTO user VALUES(SEQ_USER.NEXTVAL,'차정원','USER05','USER06',28,'MANGER',DEFAULT,DEFAULT);

 
 --------------------------------------------------------영화 테이블-------------------------------------------------
CREATE TABLE cinema_MOVIE(
    MV_NO NUMBER PRIMARY KEY,
    MV_NAME VARCHAR2(50) NOT NULL,
    MV_DATE DATE NOT NULL,
    MV_SRATNUM NUMBER NOT NULL,
    user_no NUMBER NOT NULL,
    FOREIGN KEY (user_no) REFERENCES user(user_no)
)
CREATE SEQUENCE SEQ_MOVIE
NOCYCLE;

INSERT INTO cinema_MOVIE VALUES(SEQ_MOVIE.NEXTVAL,'어벤져스',sysdate,50,4);
INSERT INTO cinema_MOVIE VALUES(SEQ_MOVIE.NEXTVAL,'닥터스트레인지',sysdate,60,4);
INSERT INTO cinema_MOVIE VALUES(SEQ_MOVIE.NEXTVAL,'잠',sysdate,40,5);
INSERT INTO cinema_MOVIE VALUES(SEQ_MOVIE.NEXTVAL,'기생충',sysdate,50,5);
INSERT INTO cinema_MOVIE VALUES(SEQ_MOVIE.NEXTVAL,'진격의 거인',sysdate,50,5);



-------------------------------------------- 영화 예약 테이블-------------------------------------------------------

CREATE TABLE cinema_Reservation(
    RV_NO NUMBER PRIMARY KEY,
    user_no NUMBER NOT NULL,
    FOREIGN KEY (user_no) REFERENCES user(user_no),
    MV_NO NUMBER NOT NULL,
    FOREIGN KEY (MV_NO) REFERENCES MOVIE(MV_NO)
)

CREATE SEQUENCE SEQ_Reservation
NOCYCLE;

INSERT INTO cinema_Reservation VALUES(SEQ_Reservation.NEXTVAL,2,3);
INSERT INTO cinema_Reservation VALUES(SEQ_Reservation.NEXTVAL,3,5);
INSERT INTO cinema_Reservation VALUES(SEQ_Reservation.NEXTVAL,3,5);

CREATE OR REPLACE TRIGGER TRG_ADDRV
AFTER INSERT ON Reservation
FOR EACH ROW 
BEGIN
    UPDATE MOVIE
    SET MV_SRATNUM = MV_SRATNUM-1;
END;
/

CREATE OR REPLACE TRIGGER TRG_DELETERV
BEFORE DELETE ON Reservation
FOR EACH ROW 
BEGIN
    UPDATE MOVIE
    SET MV_SRATNUM = MV_SRATNUM+1;
END;
/



 
 




