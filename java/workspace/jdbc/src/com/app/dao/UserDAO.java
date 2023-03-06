package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.domain.UserVO;

public class UserDAO {
//	1. Connection 객체
//	-> 어떤 계정의 어떤 테이블을 연결할지를 전달해야하는 객체
	public Connection connection;

//	2. PreparedStatement 객체
//	-> 문자열로 작성한 쿼리문을 쿼리 형태로 변환 및 실행해주는 객체
	public PreparedStatement preparedStatement;

//	3. ResultSet 객체
//	-> 작성한 쿼리문의 결과값을 담아줄 객체
	public ResultSet resultSet;

//	어디서든 접근해서 사용할 수 있도록 (세션이라고 생각하자..)
	public static Long userId;
	public final int DROP = 1;
	public final int NORMAL = 0;

//	아이디 중복검사
	public boolean checkId(String userIdentification) {
		boolean check = false;
		String query = "SELECT USER_ID FROM TBL_USER WHERE USER_IDENTIFICATION = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userIdentification); // 1번째 물음표에 다음 변수를 넣는다
//			이제 쿼리 실행
//			excuteQuery()는 select문일 때만 사용함
//			이외에는 excuteUpdate()를 사용함 <- 얘는 리턴하는 값은 몇 개의 데이터를 변경했는지 개수를 리턴함
			resultSet = preparedStatement.executeQuery(); // executeQuery()의 리턴 타입은 ResultSet => Read

			check = resultSet.next(); // 조회된 결과가 있다면 check에 들어갈 것임

		} catch (SQLException e) {
			System.out.println("checkId(String) SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { // close()에서도 문제가 생길 수도 있으므로 try-catch문으로 감싸줘야 함
				if (resultSet != null) { // 뭐라도 있으면
					resultSet.close(); // 닫아라
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
//				강제 종료				
				throw new RuntimeException(e);
			}
		}
		return check;
	}

//  회원가입
	public void insert(UserVO userVO) {
		String query = "INSERT INTO TBL_USER (USER_ID, USER_IDENTIFICATION, USER_PASSWORD, USER_NAME, USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_RECOMMENDER_ID) "
				+ "VALUES(SEQ_USER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userVO.getUserIdentification());
			preparedStatement.setString(2, userVO.getUserPassword());
			preparedStatement.setString(3, userVO.getUserName());
			preparedStatement.setString(4, userVO.getUserPhone());
			preparedStatement.setString(5, userVO.getUserNickname());
			preparedStatement.setString(6, userVO.getUserEmail());
			preparedStatement.setString(7, userVO.getUserAddress());
			preparedStatement.setString(8, userVO.getUserBirth());
			preparedStatement.setString(9, userVO.getUserRecommenderId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("insert(UserVO) SQL 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

//  로그인
	public boolean login(String userIdentification, String userPassword) {
		boolean check = false;
//     아이디와 비밀번호로 USER_ID 조회
		String query = "SELECT USER_ID FROM TBL_USER WHERE USER_IDENTIFICATION = ? AND USER_PASSWORD = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
//        화면에서 입력한 아이디와 비밀번호를 쿼리에 담는다.
			preparedStatement.setString(1, userIdentification);
			preparedStatement.setString(2, userPassword);
//        쿼리 완성
			resultSet = preparedStatement.executeQuery();
			check = resultSet.next();

			if (check) {
				userId = resultSet.getLong(1);
			}

		} catch (SQLException e) {
			System.out.println("login(String, String) SQL 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return check;
	}

//  회원탈퇴, UPDATE (일반 회원: 0, 탈퇴 회원: 1)
	public void drop() {
		String query = "UPDATE TBL_USER SET USER_STATUS = ? WHERE USER_ID = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, DROP);
			preparedStatement.setLong(2, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("drop() SQL 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

//  아이디 찾기(휴대폰 번호)
	public String selectId(String userPhone) {
		String userIdentification = null;
		String query = "SELECT USER_IDENTIFICATION FROM TBL_USER WHERE USER_PHONE = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userPhone);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			userIdentification = resultSet.getString(1);
		} catch (SQLException e) {
			System.out.println("selectId(String) SQL 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return userIdentification;
	}

//  비밀번호 변경 (로그인 후 현재 비밀번호, 새로운 비밀번호)
	public void changePassword(String userPassword, String newPassword) {
		String query = "UPDATE TBL_USER SET USER_PASSWORD = ? WHERE USER_ID = ? AND USER_PASSWORD = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setLong(2, userId);
			preparedStatement.setString(3, userPassword);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("changePassword(String, String) SQL 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

//  회원정보 수정 (닉네임 수정)
	public void update(UserVO userVO) {
		String query = "UPDATE TBL_USER SET USER_NICKNAME = ? WHERE USER_ID = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userVO.getUserNickname());
			preparedStatement.setLong(2, userId);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update(UserVO) SQL 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

//회원정보 조회
	public UserVO select() {
		UserVO userVO = new UserVO();
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_PASSWORD, USER_NAME, USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_RECOMMENDER_ID, USER_STATUS "
				+ "FROM TBL_USER WHERE USER_ID = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();

			userVO.setUserId(resultSet.getLong(1));
			userVO.setUserIdentification(resultSet.getString(2));
			userVO.setUserPassword(resultSet.getString(3));
			userVO.setUserName(resultSet.getString(4));
			userVO.setUserPhone(resultSet.getString(5));
			userVO.setUserNickname(resultSet.getString(6));
			userVO.setUserEmail(resultSet.getString(7));
			userVO.setUserAddress(resultSet.getString(8));
			userVO.setUserBirth(resultSet.getString(9));
			userVO.setUserRecommenderId(resultSet.getString(10));
			userVO.setUserStatus(resultSet.getString(11));

		} catch (SQLException e) {
			System.out.println("update(UserVO) SQL 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		return userVO;
	}

//  추천수

//  나를 추천한 사람

//  내가 추천한 사람
}
