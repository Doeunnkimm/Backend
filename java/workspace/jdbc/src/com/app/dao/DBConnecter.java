package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecter {
	public static Connection getConnection() {
		Connection connection = null;
		
//		연결에 필요한 정보
		String userName = "hr";
		String password = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
//		build한 jar파일에 있는 드라이버 파일을 직접 메모리에 할당하고서 사용해야함
//		작성한 경로가 잘못될 수도 있으므로 try-catch문 작성해야 함
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결 정보 오류");
			e.printStackTrace();
		}
		
		return connection;
	}
}
