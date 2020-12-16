/* 회원정보 */
DROP TABLE MEMBER 
	CASCADE CONSTRAINTS;

/* MY팀 */
DROP TABLE MY_T 
	CASCADE CONSTRAINTS;

/* 목적내용 */
DROP TABLE PP_DETAIL 
	CASCADE CONSTRAINTS;

/* 팀 */
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

/* 응답 대기중 */
DROP TABLE CALL 
	CASCADE CONSTRAINTS;

/* 마지막에 수정한 팀 */
DROP TABLE L_TEAM 
	CASCADE CONSTRAINTS;

select * from tab;

/* 회원정보 */
CREATE TABLE MEMBER (
	M_IDX NUMBER(20) NOT NULL, /* 회원번호 */
	ID VARCHAR2(20) NOT NULL, /* 아이디 */
	PW VARCHAR2(20) NOT NULL, /* 비밀번호 */
	NAME VARCHAR2(20) NOT NULL, /* 이름 */
	PHONE VARCHAR2(20) NOT NULL /* 핸드폰 */
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

/* 팀 */
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
	D_PURP VARCHAR2(200), /* 기획목적 */
	D_CON VARCHAR2(200),  /* 기획내용 */
	T_IDX NUMBER(20) /* 팀번호 */
);

SELECT * FROM TAB;
SELECT * FROM DESIGN;


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
	WORK VARCHAR2(200), /* 업무 제목 */
	W_PROC NUMBER(1), /* 업무 진행도 */
	W_SDATE DATE, /* 업무 시작날짜 */
	W_EDATE DATE, /* 업무 완료날짜 */
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

/* 응답 대기중 */
CREATE TABLE CALL (
	M_IDX NUMBER(20), /* 회원번호 */
	T_IDX NUMBER(20) /* 팀번호 */
);

/* 마지막에 수정한 팀 */
CREATE TABLE L_TEAM (
	M_IDX NUMBER(20) NOT NULL, /* 회원번호 */
	T_IDX NUMBER(20) /* 팀번호 */
);

CREATE UNIQUE INDEX PK_L_TEAM
	ON L_TEAM (
		M_IDX ASC
	);

ALTER TABLE L_TEAM
	ADD
		CONSTRAINT PK_L_TEAM
		PRIMARY KEY (
			M_IDX
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

ALTER TABLE CALL
	ADD
		CONSTRAINT FK_MEMBER_TO_CALL
		FOREIGN KEY (
			M_IDX
		)
		REFERENCES MEMBER (
			M_IDX
		);

ALTER TABLE CALL
	ADD
		CONSTRAINT FK_TEAM_TO_CALL
		FOREIGN KEY (
			T_IDX
		)
		REFERENCES TEAM (
			T_IDX
		);

ALTER TABLE L_TEAM
	ADD
		CONSTRAINT FK_MEMBER_TO_L_TEAM
		FOREIGN KEY (
			M_IDX
		)
		REFERENCES MEMBER (
			M_IDX
		);

ALTER TABLE L_TEAM
	ADD
		CONSTRAINT FK_TEAM_TO_L_TEAM
		FOREIGN KEY (
			T_IDX
		)
		REFERENCES TEAM (
			T_IDX
		);
	
/* 업무 */
CREATE TABLE CONFERENCE (
	C_IDX NUMBER(20) NOT NULL, /* 회의번호 */
	C_TITLE VARCHAR2(50) NOT NULL, /* 회의제목 */
	C_CONTENT VARCHAR2(300) NOT NULL, /* 회의내용 */
	C_DATE DATE NOT NULL, /* 회의 작성날짜 */
	T_IDX NUMBER(20) NOT NULL /* 팀번호 */
);		
		
/* 시퀀스 생성 */
CREATE SEQUENCE SQ_MIDX INCREMENT BY 1  START WITH 100 NOCYCLE NOCACHE; /* 회원번호 생성 */
CREATE SEQUENCE SQ_TIDX INCREMENT BY 1  START WITH 100 NOCYCLE NOCACHE;	/* 팀번호 생성 */
CREATE SEQUENCE SQ_WIDX INCREMENT BY 1  START WITH 100 NOCYCLE NOCACHE;	/* 업무번호 생성 */
CREATE SEQUENCE SQ_DIDX INCREMENT BY 1  START WITH 100 NOCYCLE NOCACHE;	/* 기획번호 생성 */
CREATE SEQUENCE SQ_CIDX INCREMENT BY 1  START WITH 100 NOCYCLE NOCACHE;	/* 회의번호 생성 */

--------------------관리자ID----------------------
INSERT INTO MEMBER VALUES(1, 'admin', 'admin', '신동재', '01012345678');
INSERT INTO MEMBER VALUES(2, 'abcd', 'abcd', '김경동', '01011112222');
INSERT INTO MEMBER VALUES(3, 'cccc', 'cccc', '이성찬', '01033334444');
INSERT INTO MEMBER VALUES(4, 'dddd', 'dddd', '관리자4', '01055552222');
INSERT INTO MEMBER VALUES(5, 'eeee', 'eeee', '관리자5', '01066662222');
INSERT INTO MEMBER VALUES(SQ_MIDX.NEXTVAL,'asd','123','신똥','01077773333');
--------------------팀 만들기----------------------
INSERT INTO TEAM VALUES(1, '하나 팀');
INSERT INTO TEAM VALUES(2, '둘 팀');
INSERT INTO TEAM VALUES(3, '셋 팀');
INSERT INTO TEAM VALUES(4, '넷 팀');
INSERT INTO TEAM VALUES(5, '다섯 팀');
INSERT INTO TEAM VALUES(6, '여섯 팀');
--------------------팀, ID 연동 & 마지막 수정한 팀 테이블----------------------
INSERT INTO MY_T VALUES(1, 1);
INSERT INTO MY_T VALUES(1, 2);
INSERT INTO MY_T VALUES(2, 3);
INSERT INTO MY_T VALUES(2, 6);
INSERT INTO MY_T VALUES(3, 1);

INSERT INTO L_TEAM VALUES(1, 1);
INSERT INTO L_TEAM VALUES(2, 6);
INSERT INTO L_TEAM VALUES(3, 1);
--------------------1팀 기획----------------------
INSERT INTO DESIGN VALUES(1, '첫번째 기획서' , 1);
--------------------1팀 기획 목적----------------------
INSERT INTO D_PURP VALUES(1, '첫번째 기획서의 목적 하나');
INSERT INTO D_PURP VALUES(1, '첫번째 기획서의 목적 둘');
INSERT INTO D_PURP VALUES(1, '첫번째 기획서의 목적 셋');
INSERT INTO D_PURP VALUES(1, '첫번째 기획서의 목적 넷');
--------------------1팀 기획 기능(내용)----------------------
INSERT INTO D_CON VALUES(1, '첫번째 기획서에서 보장하는 기능 하나');
INSERT INTO D_CON VALUES(1, '첫번째 기획서에서 보장하는 기능 둘');
--------------------1팀 업무----------------------
INSERT INTO WORK(W_IDX, WORK, W_PROC, T_IDX) VALUES(0, '업무 제로', 1, 1);
INSERT INTO WORK(W_IDX, WORK, W_PROC, T_IDX) VALUES(1, '업무 하나', 1, 1);
INSERT INTO WORK(W_IDX, WORK, W_PROC, W_SDATE, W_MEM, T_IDX) VALUES(2, '업무 둘', 2, TO_DATE('2020-12-10', 'YYYY-MM-DD'), '신동재', 1);
INSERT INTO WORK(W_IDX, WORK, W_PROC, W_SDATE, W_EDATE, W_MEM, T_IDX) VALUES(3, '업무 셋', 3, TO_DATE('2020-12-11', 'YYYY-MM-DD'), TO_DATE('2020-12-20', 'YYYY-MM-DD'), '이성찬', 1);
INSERT INTO WORK(W_IDX, WORK, W_PROC, W_SDATE, W_MEM, T_IDX) VALUES(4, '업무 넷', 2, TO_DATE('2020-12-11', 'YYYY-MM-DD'), '신동재', 1);
--------------------팀 초대 요청----------------------
INSERT INTO CALL VALUES(2, 1);

--------------------종류별 셀렉트문----------------------
SELECT * FROM TAB;
SELECT * FROM DESIGN;
SELECT * FROM D_CON;
SELECT * FROM D_PURP;
SELECT * FROM MEMBER;
SELECT * FROM MY_T;
SELECT * FROM PP_DETAIL;
SELECT * FROM TEAM;
SELECT * FROM WORK;
SELECT * FROM CALL;
SELECT * FROM L_TEAM;

/* 순번 매긴 팀 리스트 가져오기 */
SELECT ROWNUM, A.*
FROM(SELECT M_IDX AS MIDX, MY_T.T_IDX AS TIDX, T_NAME AS TNAME
FROM MY_T, TEAM WHERE MY_T.T_IDX=TEAM.T_IDX AND M_IDX=2
ORDER BY TIDX DESC
) A;
/* 마지막에 수정한 팀 가져오기 */
SELECT ROWNUM
FROM(SELECT ROWNUM, A.*
FROM(SELECT M_IDX AS MIDX, MY_T.T_IDX AS TIDX, T_NAME AS TNAME
FROM MY_T, TEAM WHERE MY_T.T_IDX=TEAM.T_IDX AND M_IDX=3
ORDER BY TIDX DESC
) A)
WHERE TIDX = (SELECT T_IDX FROM L_TEAM WHERE M_IDX=3)

/* 팀 맴버 가져오기 */
SELECT NAME FROM MY_T,MEMBER 
WHERE MY_T.M_IDX=MEMBER.M_IDX AND T_IDX=1;
/* 기획 이름 가져오기 */
SELECT D_IDX AS DIDX, D_NAME AS DNAME FROM DESIGN WHERE T_IDX=1;
/* 기획 기능(내용) 가져오기 */
SELECT D_CON FROM D_CON WHERE D_IDX=1;
/* 업무DTO 가져오기 */
SELECT W_IDX AS WIDX, WORK, W_PROC AS WPROC, TO_CHAR(W_SDATE, 'yyyy-mm-dd' )AS WSDATE,
TO_CHAR(W_EDATE, 'yyyy-mm-dd' )AS WEDATE, W_MEM AS WMEM, T_IDX AS TIDX 
FROM WORK WHERE T_IDX=1
ORDER BY WPROC DESC;
/* 팀 요청 목록 가져오기 */
SELECT NAME FROM MEMBER, CALL 
WHERE MEMBER.M_IDX = CALL.M_IDX AND T_IDX=1;

<<<<<<< HEAD
=======
CREATE SEQUENCE SQ_MIDX INCREMENT BY 1  START WITH 100 NOCYCLE NOCACHE;
CREATE SEQUENCE SQ_TIDX INCREMENT BY 1  START WITH 100 NOCYCLE NOCACHE;
CREATE SEQUENCE SQ_WIDX INCREMENT BY 1  START WITH 100 NOCYCLE NOCACHE;
CREATE SEQUENCE SQ_DIDX INCREMENT BY 1  START WITH 100 NOCYCLE NOCACHE;
CREATE SEQUENCE SQ_CIDX INCREMENT BY 1  START WITH 100 NOCYCLE NOCACHE;

drop sequence SQ_MIDX;
select * from seq
select * from work


SELECT * FROM WORK WHERE T_IDX=1

INSERT INTO CONFERENCE VALUES(SQ_CIDX.nextval, '회의 제목', '회의 내용', SYSDATE, 1);
INSERT INTO CONFERENCE VALUES(SQ_CIDX.nextval, #{c_title}, #{c_content}, SYSDATE, #{t_idx})

SELECT * FROM CONFERENCE WHERE T_IDX=1


>>>>>>> branch 'master' of https://github.com/lscstar28/gather.git