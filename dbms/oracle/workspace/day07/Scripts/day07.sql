/* 외부 조인 */
/* JOIN할 때 선행 또는 후행 중 하나의 테이블 정보를 모두 확인하고 싶을 때 사용한다  */

/* STARDIUM 테이블에서 홈 팀인 정보 조회, 홈 팀이 없어도 경기장은 모두 조회 */
SELECT * FROM STADIUM;
SELECT * FROM TEAM;

/* NVL은 NULL값을 대체할 수 있음 */
SELECT NVL(T.TEAM_ID, '공용') TEMA_ID, STADIUM_NAME
FROM TEAM T RIGHT OUTER JOIN STADIUM S /* 후행 테이블의 정보를 다 보고 싶을 거니까 RIGHT */
ON T.STADIUM_ID = S.STADIUM_ID ;

/*브론즈*/
/*EMPLOYEES 테이블에서 JOB_ID가 SA_REP인 사원 전체 조회*/
SELECT * FROM EMPLOYEES;
SELECT * FROM JOBS;

SELECT * FROM EMPLOYEES WHERE JOB_ID = 'SA_REP';

/*실버*/
/*PLAYER 테이블에서 팀 별 최대 몸무게*/
SELECT TEAM_ID, MAX(WEIGHT) 
FROM PLAYER
GROUP BY TEAM_ID;

/*골드*/
/*AVG 함수를 쓰지 않고 PLAYER 테이블에서 선수들의 평균 키 구하기*/
SELECT SUM(HEIGHT) / COUNT(HEIGHT) "평균 키" FROM PLAYER;

/*플래티넘*/
/*DEPT 테이블의 LOC별 평균 급여를 반올림한 값과 각 LOC별 SAL 총 합을 조회, 반올림: ROUND()*/
SELECT LOC, NVL(ROUND(AVG(SAL), 2), 0) "평균 급여", NVL(SUM(SAL), 0) "총 합"
FROM DEPT D LEFT OUTER JOIN EMP E
ON D.DEPTNO = E.DEPTNO
GROUP BY LOC;

SELECT * FROM EMP;
SELECT * FROM DEPT;

/*다이아*/
/*PLAYER 테이블에서 팀 별 최대 몸무게인 선수의 전체 정보와 팀 명, 팀 전화번호 조회*/
SELECT * FROM PLAYER
WHERE WEIGHT = (SELECT MAX(WEIGHT) FROM PLAYER);

SELECT T.TEAM_ID, P.*, T.TEAM_NAME, T.TEL
FROM TEAM T JOIN
(
	SELECT P2.*
	FROM
	(
		SELECT TEAM_ID, MAX(WEIGHT) MW
		FROM PLAYER 
		GROUP BY TEAM_ID
	) P1
	JOIN PLAYER P2
	ON P1.TEAM_ID = P2.TEAM_ID AND P1.MW = P2.WEIGHT
) P
ON P.TEAM_ID = T.TEAM_ID;


/*마스터*/
/*EMP 테이블에서 HIREDATE가 FORD의 입사년도와 같은 사원 전체 정보 조회*/
SELECT * FROM EMP
WHERE TO_CHAR(HIREDATE, 'YYYY') = (SELECT TO_CHAR(HIREDATE, 'YYYY')  FROM EMP WHERE ENAME='FORD');


/*EMPLOYEES 테이블에서 사원의 매니저 이름, 사원의 이름 조회, 매니저가 없는 사원은 본인이 매니저임을 표시*/
SELECT E2.LAST_NAME || E2.FIRST_NAME  "매니저 이름", E1.LAST_NAME || E1.FIRST_NAME "사원 이름"
FROM EMPLOYEES E1 JOIN EMPLOYEES E2
ON NVL(E1.MANAGER_ID, E1.EMPLOYEE_ID) = E2.EMPLOYEE_ID;

SELECT NVL(E2.LAST_NAME, E1.LAST_NAME) || NVL(E2.FIRST_NAME, E1.FIRST_NAME) "매니저 이름", E1.LAST_NAME || E1.FIRST_NAME "사원 이름"
FROM EMPLOYEES E1 LEFT OUTER JOIN EMPLOYEES E2
ON E1.MANAGER_ID = E2.EMPLOYEE_ID;


/*EMPLOYEES에서 부서별 매니저와 부서별 사원 조회 */
SELECT D.DEPARTMENT_NAME, D.MANAGER_NAME, E.* FROM 
(
	SELECT E.DEPARTMENT_ID, D.DEPARTMENT_NAME, E.LAST_NAME || E.FIRST_NAME "MANAGER_NAME"
	FROM DEPARTMENTS D JOIN EMPLOYEES E
	ON D.MANAGER_ID = E.EMPLOYEE_ID
) D
RIGHT OUTER JOIN EMPLOYEES E
ON E.DEPARTMENT_ID = E.DEPARTMENT_ID;


/*EMPLOYEES에서 각 사원별로 JOB_ID(매니저)와 JOB_ID(사원) 조회*/
SELECT E2.LAST_NAME, E1.JOB_ID "내가 관리하는 부서", E2.JOB_ID "내가 소속된 부서" FROM
(
	SELECT JOB_ID, MANAGER_ID  
	FROM EMPLOYEES
	GROUP BY JOB_ID, MANAGER_ID
) E1 
FULL OUTER JOIN EMPLOYEES E2
ON E1.MANAGER_ID = E2.EMPLOYEE_ID
ORDER BY E2.LAST_NAME;



















