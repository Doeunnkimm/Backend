/* VIEW */
/* CREATE VIEW [이름] AS [쿼리문] */

/*
 *  기존의 테이블을 그래도 놔둔 채 필요한 컬럼들 및 새로운 컬럼을 만든 가상 테이블
 *  실제 데이터가 저장되는 것은 아니지만, VIEW를 통해서 데이터를 관리할 수 있음
 * 
 * ** SELECT절만 사용가능
 * 
 * 	VIEW를 사용했을 때 장점 3가지
 * 
 * - 독립성 : 다른 곳에서 접근하지 못하도록 하는 성질 -> 일부 컬럼만 사용할 수 있도록 일부로 VIEW로 접근하도록
 * - 편리성 : 길고 복잡한 쿼리문을 매번 작성할 필요가 없다
 * - 보안성 : 기존의 쿼리문(VIEW를 만들기 위한 쿼리문)이 보이지 않는다
 * 
 * */

DROP VIEW VIEW_PLAYER;
CREATE VIEW VIEW_PLAYER AS SELECT PLAYER_NAME  FROM PLAYER;
SELECT * FROM VIEW_PLAYER;

/* PLAYER 테이블에 나이 컬럼 추가한 뷰 만들기 */
CREATE VIEW VIEW_PLAYER AS
SELECT FLOOR(((SYSDATE - BIRTH_DATE) / 365))  AGE, P.*FROM PLAYER P;

SELECT * FROM VIEW_PLAYER WHERE AGE > 40;

/* EMPOLOYESS 테이블에서 사원 이름과 그 사원의 매니저 이름이 있는 VIEW 만들기 */
CREATE VIEW VIEW_EMPOLOYEES AS
SELECT E1.LAST_NAME || E1.FIRST_NAME "사원 이름", E2.LAST_NAME || E2.FIRST_NAME "매니저 이름"
FROM EMPLOYEES E1 LEFT OUTER JOIN EMPLOYEES E2
ON E1.EMPLOYEE_ID = E2.MANAGER_ID;

SELECT * FROM VIEW_EMPOLOYEES;