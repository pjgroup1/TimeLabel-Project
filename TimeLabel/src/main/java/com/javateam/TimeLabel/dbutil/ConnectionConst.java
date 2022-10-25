package com.javateam.TimeLabel.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConst {
	// 데이터베이스 URL, USERNAME, PASSWORD 정의
	public static final String jdbcUrl =  "jdbc:mariadb://javalec-sat.crwq4oaekhum.ap-northeast-2.rds.amazonaws.com:3306/sang_db";
	public static final String username ="sang";
	public static final String password ="sang1234";
}
