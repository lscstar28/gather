/* 회원정보 */
DROP TABLE MEMBER 
	CASCADE CONSTRAINTS;

/* MY팀 */
DROP TABLE MY_T 
	CASCADE CONSTRAINTS;

/* 목적내용 */
DROP TABLE PP_DETAIL 
	CASCADE CONSTRAINTS;

/* 팀4 */
DROP TABLE TEAM 
	CASCADE CONSTRAINTS;

/* 기획 */
DROP TABLE DESIGN 
	CASCADE CONSTRAINTS;

/* 업무 */
DROP TABLE WORK 
	CASCADE CONSTRAINTS;

/* 목적 */
DROP TABLE D_PURP 
	CASCADE CONSTRAINTS;

/* 내용 */
DROP TABLE D_CON 
	CASCADE CONSTRAINTS;

/* 회원정보 */
CREATE TABLE MEMBER (
	M_IDX NUMBER(20) NOT NULL, /* 회원번호 */
	ID VARCHAR2(20) NOT NULL, /* 아이디 */
	PW VARCHAR2(20) NOT NULL, /* 비밀번호 */
	NAME VARCHAR2(20) NOT NULL, /* 이름 */
	PHONE NUMBER(20) NOT NULL /* 핸드폰 */
);

CREATE UNIQUE INDEX PK_MEMBER
	ON MEMBER (
		M_IDX ASC
	);

CREATE UNIQUE INDEX UIX_MEMBER
	ON MEMBER (
		ID ASC,
		PHONE ASC
	);

ALTER TABLE MEMBER
	ADD
		CONSTRAINT PK_MEMBER
		PRIMARY KEY (
			M_IDX
		);

ALTER TABLE MEMBER
	ADD
		CONSTRAINT UK_MEMBER
		UNIQUE (
			ID,
			PHONE
		);

/* MY팀 */
CREATE TABLE MY_T (
	M_IDX NUMBER(20), /* 회원번호 */
	T_IDX NUMBER(20) /* 팀번호 */
);

/* 목적내용 */
CREATE TABLE PP_DETAIL (
	PP_CON VARCHAR2(200), /* 내용 */
	T_IDX NUMBER(20) /* 팀번호 */
);

/* 팀4 */
CREATE TABLE TEAM (
	T_IDX NUMBER(20) NOT NULL, /* 팀번호 */
	T_NAME VARCHAR2(20) NOT NULL /* 이름 */
);

CREATE UNIQUE INDEX PK_TEAM
	ON TEAM (
		T_IDX ASC
	);

ALTER TABLE TEAM
	ADD
		CONSTRAINT PK_TEAM
		PRIMARY KEY (
			T_IDX
		);

/* 기획 */
CREATE TABLE DESIGN (
	D_IDX NUMBER(20) NOT NULL, /* 기획번호 */
	D_NAME VARCHAR2(200), /* 기획주제 */
	T_IDX NUMBER(20) /* 팀번호 */
);

CREATE UNIQUE INDEX PK_DESIGN
	ON DESIGN (
		D_IDX ASC
	);

ALTER TABLE DESIGN
	ADD
		CONSTRAINT PK_DESIGN
		PRIMARY KEY (
			D_IDX
		);

/* 업무 */
CREATE TABLE WORK (
	W_IDX NUMBER(20) NOT NULL, /* 업무번호 */
	WORK VARCHAR2(200), /* 업무 */
	W_PROC NUMBER(1), /* 업무 진행도 */
	W_DATE DATE, /* 업무 진행날짜 */
	W_MEM VARCHAR2(20), /* 담당자 */
	T_IDX NUMBER(20) /* 팀번호 */
);

CREATE UNIQUE INDEX PK_WORK
	ON WORK (
		W_IDX ASC
	);

ALTER TABLE WORK
	ADD
		CONSTRAINT PK_WORK
		PRIMARY KEY (
			W_IDX
		);

/* 목적 */
CREATE TABLE D_PURP (
	D_IDX NUMBER(20), /* 기획번호 */
	D_PURP VARCHAR2(300) /* 기획목적 */
);

/* 내용 */
CREATE TABLE D_CON (
	D_IDX NUMBER(20), /* 기획번호 */
	D_CON VARCHAR2(300) /* 기획내용 */
);

ALTER TABLE MY_T
	ADD
		CONSTRAINT FK_MEMBER_TO_MY_T
		FOREIGN KEY (
			M_IDX
		)
		REFERENCES MEMBER (
			M_IDX
		);

ALTER TABLE MY_T
	ADD
		CONSTRAINT FK_TEAM_TO_MY_T
		FOREIGN KEY (
			T_IDX
		)
		REFERENCES TEAM (
			T_IDX
		);

ALTER TABLE PP_DETAIL
	ADD
		CONSTRAINT FK_TEAM_TO_PP_DETAIL
		FOREIGN KEY (
			T_IDX
		)
		REFERENCES TEAM (
			T_IDX
		);

ALTER TABLE DESIGN
	ADD
		CONSTRAINT FK_TEAM_TO_DESIGN
		FOREIGN KEY (
			T_IDX
		)
		REFERENCES TEAM (
			T_IDX
		);

ALTER TABLE WORK
	ADD
		CONSTRAINT FK_TEAM_TO_WORK
		FOREIGN KEY (
			T_IDX
		)
		REFERENCES TEAM (
			T_IDX
		);

ALTER TABLE D_PURP
	ADD
		CONSTRAINT FK_DESIGN_TO_D_PURP
		FOREIGN KEY (
			D_IDX
		)
		REFERENCES DESIGN (
			D_IDX
		);

ALTER TABLE D_CON
	ADD
		CONSTRAINT FK_DESIGN_TO_D_CON
		FOREIGN KEY (
			D_IDX
		)
		REFERENCES DESIGN (
			D_IDX
		);


SELECT * FROM TAB;
SELECT * FROM DESIGN;
SELECT * FROM D_CON;
SELECT * FROM D_PURP;
SELECT * FROM MEMBER;
SELECT * FROM MY_T;
SELECT * FROM PP_DETAIL;
SELECT * FROM TEAM;
SELECT * FROM WORK_DETAIL;

SELECT M_IDX AS MIDX, MY_T.T_IDX AS TIDX, T_NAME as TNAME
FROM MY_T, TEAM WHERE MY_T.T_IDX=TEAM.T_IDX and MY_T.T_IDX=6;

select name from member where m_idx=();
SELECT MY_T.M_IDX, NAME FROM MY_T,MEMBER WHERE MY_T.M_IDX=MEMBER.M_IDX AND T_IDX=6;

SELECT D_IDX AS DIDX, D_NAME AS DNAME FROM DESIGN WHERE T_IDX=6;

SELECT D_PURP FROM D_PURP WHERE D_IDX=1;


CREATE SEQUENCE SEQ_MEM INCREMENT BY 1  START WITH 10000 NOCYCLE NOCACHE;

--------------------관리자ID----------------------
INSERT INTO MEMBER VALUES(1, 'admin', 'admin', '관리자A');
INSERT INTO MEMBER VALUES(2, 'abcd', 'abcd', '관리자B');
INSERT INTO MEMBER VALUES(3, 'cccc', 'cccc', '관리자C');

INSERT INTO MY_T VALUES(2, 6);
INSERT INTO DESIGN VALUES(1, '여섯번째 기획서' , 6);

INSERT INTO D_PURP VALUES(1, '여섯번째 기획서의 목적 둘');
INSERT INTO D_PURP VALUES(1, '여섯번째 기획서의 목적 셋');
INSERT INTO D_PURP VALUES(1, '여섯번째 기획서의 목적 넷');
INSERT INTO D_PURP VALUES(1, '여섯번째 기획서의 목적 하나');






