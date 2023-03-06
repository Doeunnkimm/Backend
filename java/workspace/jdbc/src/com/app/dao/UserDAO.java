package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.domain.UserVO;

public class UserDAO {
//	1. Connection ��ü
//	-> � ������ � ���̺��� ���������� �����ؾ��ϴ� ��ü
	public Connection connection;

//	2. PreparedStatement ��ü
//	-> ���ڿ��� �ۼ��� �������� ���� ���·� ��ȯ �� �������ִ� ��ü
	public PreparedStatement preparedStatement;

//	3. ResultSet ��ü
//	-> �ۼ��� �������� ������� ����� ��ü
	public ResultSet resultSet;

//	��𼭵� �����ؼ� ����� �� �ֵ��� (�����̶�� ��������..)
	public static Long userId;
	public final int DROP = 1;
	public final int NORMAL = 0;

//	���̵� �ߺ��˻�
	public boolean checkId(String userIdentification) {
		boolean check = false;
		String query = "SELECT USER_ID FROM TBL_USER WHERE USER_IDENTIFICATION = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userIdentification); // 1��° ����ǥ�� ���� ������ �ִ´�
//			���� ���� ����
//			excuteQuery()�� select���� ���� �����
//			�̿ܿ��� excuteUpdate()�� ����� <- ��� �����ϴ� ���� �� ���� �����͸� �����ߴ��� ������ ������
			resultSet = preparedStatement.executeQuery(); // executeQuery()�� ���� Ÿ���� ResultSet => Read

			check = resultSet.next(); // ��ȸ�� ����� �ִٸ� check�� �� ����

		} catch (SQLException e) {
			System.out.println("checkId(String) SQL�� ����");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { // close()������ ������ ���� ���� �����Ƿ� try-catch������ ������� ��
				if (resultSet != null) { // ���� ������
					resultSet.close(); // �ݾƶ�
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
//				���� ����				
				throw new RuntimeException(e);
			}
		}
		return check;
	}

//  ȸ������
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
			System.out.println("insert(UserVO) SQL ����");
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

//  �α���
	public boolean login(String userIdentification, String userPassword) {
		boolean check = false;
//     ���̵�� ��й�ȣ�� USER_ID ��ȸ
		String query = "SELECT USER_ID FROM TBL_USER WHERE USER_IDENTIFICATION = ? AND USER_PASSWORD = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
//        ȭ�鿡�� �Է��� ���̵�� ��й�ȣ�� ������ ��´�.
			preparedStatement.setString(1, userIdentification);
			preparedStatement.setString(2, userPassword);
//        ���� �ϼ�
			resultSet = preparedStatement.executeQuery();
			check = resultSet.next();

			if (check) {
				userId = resultSet.getLong(1);
			}

		} catch (SQLException e) {
			System.out.println("login(String, String) SQL ����");
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

//  ȸ��Ż��, UPDATE (�Ϲ� ȸ��: 0, Ż�� ȸ��: 1)
	public void drop() {
		String query = "UPDATE TBL_USER SET USER_STATUS = ? WHERE USER_ID = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, DROP);
			preparedStatement.setLong(2, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("drop() SQL ����");
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

//  ���̵� ã��(�޴��� ��ȣ)
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
			System.out.println("selectId(String) SQL ����");
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

//  ��й�ȣ ���� (�α��� �� ���� ��й�ȣ, ���ο� ��й�ȣ)
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
			System.out.println("changePassword(String, String) SQL ����");
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

//  ȸ������ ���� (�г��� ����)
	public void update(UserVO userVO) {
		String query = "UPDATE TBL_USER SET USER_NICKNAME = ? WHERE USER_ID = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userVO.getUserNickname());
			preparedStatement.setLong(2, userId);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update(UserVO) SQL ����");
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

//ȸ������ ��ȸ
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
			System.out.println("update(UserVO) SQL ����");
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

//  ��õ��

//  ���� ��õ�� ���

//  ���� ��õ�� ���
}