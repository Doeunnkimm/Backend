UPDATE PLAYER 
SET NICKNAME = '없음'
WHERE NICKNAME IS NULL;

SELECT* FROM PLAYER;

ROLLBACK; /* 가장 마지막 커밋 시점으로 돌아감 */

/* PLAYER 테이블에서 TEAM_ID가 'K01'인 선수 이름을 내 이름으로 바꾸기 */
UPDATE PLAYER
SET PLAYER_NAME = '김도은'
WHERE TEAM_ID = 'K01';

SELECT * FROM PLAYER WHERE TEAM_ID = 'K01';

/* PLAYER 테이블에서 POSITION이 MF인 선수 삭제하기 */
DELETE FROM PLAYER WHERE "POSITION" = 'MF';

SELECT * FROM PLAYER  WHERE "POSITION" = 'MF';

/* PLAYER 테이블에서 HEIGHT가 180인 선수 삭제하기 */
DELETE FROM PLAYER WHERE HEIGHT >= 180;

SELECT * FROM PLAYER WHERE HEIGHT >=180;

/* NULL */
/* PLAYER 테이블에서 POSITION이 NULL인 선수 */
SELECT * FROM PLAYER  WHERE "POSITION" IS NULL;

/* PLAYER 테이블에서 POSITION이 NULL이 아닌 선수 */
SELECT * FROM PLAYER WHERE NOT "POSITION" IS NULL;
SELECT * FROM PLAYER p WHERE "POSITION" IS NOT NULL;

/* AS(ALIAS) 별칭 */
/* SELECT절과 FROM절에서 사용할 수 있다. */
/* 선수 이름과 생일 조회 */
SELECT PLAYER_NAME "선수 이름", BIRTH_DATE 선수생일  FROM PLAYER;

/* PLAYER 테이블에서 BACK_NO을 "등 번호"로, NICKNAME을 "선수 별명"으로 변경하여 검색 */
SELECT BACK_NO "등 번호", NICKNAME "선수 별명" FROM PLAYER;

/* CONCATENATION: 연결, || */
SELECT PLAYER_NAME || '님의 영어 이름은 ' || E_PLAYER_NAME  FROM PLAYER;

/* PLAYER_NAME의 POSITION은 000이다 */
SELECT PLAYER_NAME || '님의 포지션은 ' || "POSITION" || ' 입니다' FROM PLAYER;

/* LIKE: 포함된 문자열 값을 찾고, 문자의 개수도 제한을 줄 수 있다. */

/*
 * WHERE [컬럼명] LIKE '서식';
 * 
 * %: 모든 것
 * _: 글자 수
 * 
 * 예)
 * '%A' : A로 끝나는 모든 것
 * 'A%' : A로 시작하는 모든 것
 * '%A%' : A가 포함된 모든 것
 * 'A__' : A로 시작하고 3글자
 * '_A' : A로 끝나는 2글자
 * 
 * */

/* '천마'로 끝나는 팀 이름 조회 */
SELECT TEAM_ID, TEAM_NAME FROM TEAM
WHERE TEAM_NAME LIKE '%천마';

/* PLAYER 테이블에서 김씨 찾기 */
SELECT * FROM PLAYER WHERE PLAYER_NAME LIKE '김%';

/* PLAYER 테이블에서 김씨 두 자(외 자) 찾기 */
SELECT * FROM PLAYER WHERE PLAYER_NAME LIKE '김_';

/* PLAYER 테이블에서 김씨와 이씨 찾기 */
SELECT * FROM PLAYER 
WHERE PLAYER_NAME LIKE '김%' OR PLAYER_NAME LIKE '이%';

/* PLAYER 테이블에서 이씨가 아닌 사람 찾기 */
SELECT * FROM PLAYER WHERE PLAYER_NAME NOT LIKE '이%';

/*
 *  집계함수 : ***결과 행 1개***
 * 
 * ※ 주의사항 : NULL은 포함시키지 않는다, WHERE 절에서 사용 불가
 * 
 * 평균: AVG()
 * 최대값: MAX()
 * 최소값: MIN()
 * 총 합: SUM()
 * 개수: COUNT()
 * 
 *  */

SELECT AVG(HEIGHT), MAX(HEIGHT), MIN(HEIGHT), SUM(HEIGHT), COUNT(HEIGHT) FROM PLAYER;

/* 
 * 정렬
 * 
 * ORDER BY 컬럼명 ASC, ... ASC : 오름차순
 * ORDER BY 컬럼명 DESC, ... DESC : 내림차순
 * 
 *  */

/* PLAYER 테이블에서 HEIGHT를 오름차순 */
SELECT * FROM PLAYER
ORDER BY HEIGHT;

/* PLAYER 테이블에서 HEIGHT를 내림차순, 그런데 같은 경우에 대해서는 WEIGHT를 내림차순으로 */
SELECT * FROM PLAYER
ORDER BY HEIGHT DESC, HEIGHT DESC;

/* GROUP BY: ~별 
 * **** GROUP BY에서는 꼭 WHERE절에서 거를 수 있는 데이터에 대해서는
 * 먼저 WHERE 절에서 거르고 그룹화하자!!!!!
 * 
 * WHERE절이 GROUP BY보다 먼저 실행되기 때문에
 * WHERE절에서 우선적으로 처리할 조건식을 작성해야 효율적이다.
 * 
 * *** 묶기 전에는 WHERE절, 묶고 나서는 HAVING 절을 사용하여 적절히 문제를 해결할 줄 알아야 한다!!!!
 * */

/* HAVING은 GROUP BY에서의 조건식이라고 보자 */
SELECT "POSITION", AVG(HEIGHT)  FROM PLAYER
WHERE "POSITION" IS NOT NULL
GROUP BY "POSITION";

/* PLAYER 테이블에서 몸무게가 80이상인 선수들의 평균 키가 180 이상인 포지션 검색 */
SELECT "POSITION", AVG(HEIGHT) FROM PLAYER
WHERE WEIGHT >= 80
GROUP BY "POSITION"
HAVING AVG(HEIGHT) >= 180;

/*EMPLOYEES 테이블에서 JOB_ID별 평균 SALARY가 10000미만인 JOB_ID 검색*/
SELECT JOB_ID || '의 평균 SALARY는 ' ||  AVG(SALARY) || ' 입니다' FROM EMPLOYEES
GROUP BY JOB_ID
HAVING AVG(SALARY) < 10000
ORDER BY AVG(SALARY);

SELECT JOB_ID "부서 ID",  AVG(SALARY) "평균 월급" FROM EMPLOYEES
GROUP BY JOB_ID
HAVING AVG(SALARY) < 10000
ORDER BY AVG(SALARY);

/* 
 * SUB QUERY 
 * 
 * FROM 절: IN LINE VIEW
 * SELECT절: SCALAR
 * WHERE절: SUB QUERY
 * 
 * */

/* PLAYER 테이블에서 전체 평균 키와 포지션 별 평균 키 구하기 */
/*                        -----------    ---------------        */
SELECT "POSITION" , AVG(HEIGHT),
(
	SELECT AVG(HEIGHT) FROM PLAYER
)
FROM PLAYER
WHERE "POSITION" IS NOT NULL
GROUP BY "POSITION" ;

/* PLAYER 테이블에서 TEAM_ID가 'K01'인 선수 중에서 POSTION이 'GK'인 선수*/
SELECT * FROM 
(
	SELECT PLAYER_NAME, "POSITION"  FROM PLAYER WHERE TEAM_ID = 'K01'
)
WHERE POSITION = 'GK';

/* PLAYER 테이블에서 평균 몸무게보다 더 많이 나가는 선수들 검색 */
SELECT * FROM PLAYER
WHERE WEIGHT > (SELECT AVG(WEIGHT) FROM PLAYER);

/* SQL 실행 순서
 * 
 * FROM > WHERE > GROUP BY > HAVING > SELECT > ORDER BY
 * 
 *  */

/* PLAYER 테이블에서 정남일 선수가 소속된 팀의 선수들 조회 */
SELECT * FROM PLAYER
WHERE TEAM_ID  = (SELECT TEAM_ID FROM PLAYER WHERE PLAYER_NAME = '정남일');

SELECT TEAM_ID FROM PLAYER WHERE PLAYER_NAME = '정남일';


/* PLAYER 테이블에서 평균 키보다 작은 선수 검색, 조회 결과가 맞는지 검사까지 한번에 하기 */
SELECT HEIGHT, (SELECT AVG(HEIGHT) FROM PLAYER) "평균 키" FROM PLAYER
WHERE HEIGHT < (SELECT AVG(HEIGHT) FROM PLAYER);


/* SCHEDULE 테이블에서 경기 일정이 20120501 ~ 20120502 사이에 있는 경기장 정보 조회 */
SELECT * FROM STADIUM WHERE
STADIUM_ID IN
(
   SELECT STADIUM_ID FROM SCHEDULE
   WHERE SCHE_DATE BETWEEN '20120501' AND '20120502'
);


/* TCL AUTO에서 NONE으로 변경!!!! */

/* PLAYER 테이블에서 NICKNAME이 NULL인 선수들을 정태민 선수의 닉네임으로 바꾸기 */
UPDATE PLAYER
SET NICKNAME = (SELECT NICKNAME FROM PLAYER WHERE PLAYER_NAME = '정태민')
WHERE NICKNAME IS NULL;

SELECT NICKNAME FROM PLAYER;
SELECT NICKNAME FROM PLAYER WHERE PLAYER_NAME = '정태민';

/* EMPLOYEE 테이블에서 평균 급여보다 낮은 사원들의 급여를 20% 인상 */
UPDATE EMPLOYEES
SET SALARY = SALARY * 1.2
WHERE SALARY < (SELECT AVG(SALARY) FROM EMPLOYEES);

SELECT SALARY FROM EMPLOYEES;

/* PLAYER 테이블에서 평균 키보다 큰 선수들을 삭제 */
DELETE FROM PLAYER WHERE HEIGHT > (SELECT AVG(HEIGHT) FROM PLAYER);










