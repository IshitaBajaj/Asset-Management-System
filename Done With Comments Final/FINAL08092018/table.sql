CREATE SEQUENCE C_seq
START WITH 1000
INCREMENT BY 1;

CREATE SEQUENCE A_seq
START WITH 10000
INCREMENT BY 1;

CREATE TABLE Composer_Master
(Composer_id NUMBER(6),
Composer_Name VARCHAR2(50),
Composer_BornDate DATE,
Composer_DiedDate DATE,
Composer_CaeipiNumber VARCHAR2(10),
Composer_MusicSocietyID CHAR(3),
Created_By NUMBER(6),
Created_On DATE,
Updated_By NUMBER(6),
Updated_On DATE,
Composer_DeletedFlag char(1),
CONSTRAINT Composer_Master_pk PRIMARY KEY(Composer_id));

CREATE TABLE User_Master
(user_id NUMBER(6),
user_password VARCHAR2(20),
created_by NUMBER(6),
created_on DATE,
updated_by NUMBER(6),
updated_on DATE,
user_type char(1),
CONSTRAINT User_Master_pk PRIMARY KEY(User_id));

CREATE TABLE MusicSociety_Master(
Composer_MusicSocietyID CHAR(3),
Composer_MusicSocietyName VARCHAR2(50));

CREATE TABLE Artist_Master
(Artist_id NUMBER(6),
Artist_Name VARCHAR2(50),
Artist_Type char(1),
Artist_BornDate DATE,
Artist_DiedDate DATE,
Created_By NUMBER(6),
Created_On DATE,
Updated_By NUMBER(6),
Updated_On DATE,
Artist_DeletedFlag char(1),
CONSTRAINT Artist_Master_pk PRIMARY KEY(Artist_id));

INSERT INTO User_Master VALUES(155201,'admin',155268,sysdate,155278,sysdate,'A');
INSERT INTO User_Master VALUES(155202,'admin',155268,sysdate,155278,sysdate,'A');
INSERT INTO User_Master VALUES(155203,'admin',155268,sysdate,155278,sysdate,'A');
INSERT INTO User_Master VALUES(144201,'user',155201,sysdate,155203,sysdate,'U');
INSERT INTO User_Master VALUES(144202,'user',155202,sysdate,155202,sysdate,'U');
INSERT INTO User_Master VALUES(144203,'user',155203,sysdate,155201,sysdate,'U');


insert into MUSICSOCIETY_MASTER values('100','ABC');
insert into MUSICSOCIETY_MASTER values('101','XYZ');
insert into MUSICSOCIETY_MASTER values('000','Not a part of society yet');

CREATE TABLE Song_Master
(Song_id NUMBER(6),
Song_Name varchar2(50),
Song_Duration TIMESTAMP,
Created_By NUMBER(6),
Created_On DATE,
Updated_By Number(6),
Updated_On DATE,
Song_DeletedFlag char(1),
CONSTRAINT Song_Master_pk PRIMARY KEY(Song_id));

CREATE TABLE Artist_Song_Assoc
(Artist_id NUMBER(6),
Song_id NUMBER(6),
Created_By NUMBER(6),
Created_On DATE,
Updated_By Number(6),
Updated_On DATE
);

CREATE TABLE Composer_Song_Assoc
(Composer_id NUMBER(6),
Song_id NUMBER(6),
Created_By NUMBER(6),
Created_On DATE,
Updated_By Number(6),
Updated_On DATE
);

delete from composer_master where composer_id=1161;
INSERT INTO Song_Master VALUES(987654,'Song1',TO_TIMESTAMP('06:50','MI:SS'),155203,SYSDATE,155201,SYSDATE,'F');
INSERT INTO Song_Master VALUES(987653,'Song2',TO_TIMESTAMP('04:40','MI:SS'),155201,SYSDATE,155203,SYSDATE,'F');
INSERT INTO Song_Master VALUES(987652,'Song3',TO_TIMESTAMP('03:23','MI:SS'),155203,SYSDATE,155203,SYSDATE,'F');
INSERT INTO Song_Master VALUES(987651,'Song4',TO_TIMESTAMP('06:50','MI:SS'),155203,SYSDATE,155201,SYSDATE,'F');

INSERT INTO COMPOSER_SONG_ASSOC VALUES(1140,987654,155201,SYSDATE,155201,SYSDATE);
INSERT INTO COMPOSER_SONG_ASSOC VALUES(1140,987652,155203,SYSDATE,155203,SYSDATE);
INSERT INTO COMPOSER_SONG_ASSOC VALUES(1140,987651,155201,SYSDATE,155201,SYSDATE);

INSERT INTO COMPOSER_SONG_ASSOC VALUES(1141,987654,155201,SYSDATE,155201,SYSDATE);
INSERT INTO COMPOSER_SONG_ASSOC VALUES(1141,987652,155203,SYSDATE,155203,SYSDATE);
INSERT INTO COMPOSER_SONG_ASSOC VALUES(1141,987651,155201,SYSDATE,155201,SYSDATE);

INSERT INTO COMPOSER_SONG_ASSOC VALUES(1142,987653,155202,SYSDATE,155202,SYSDATE);
INSERT INTO COMPOSER_SONG_ASSOC VALUES(1142,987651,155203,SYSDATE,155203,SYSDATE);
INSERT INTO COMPOSER_SONG_ASSOC VALUES(1142,987652,155201,SYSDATE,155201,SYSDATE);


select * from ARTIST_SONG_ASSOC;
select * from COMPOSER_SONG_ASSOC;
select * from COMPOSER_MASTER;
select * from USER_MASTER;
select * from MusicSociety_Master;
select * from artist_master;
SELECT * FROM SONG_MASTER;



