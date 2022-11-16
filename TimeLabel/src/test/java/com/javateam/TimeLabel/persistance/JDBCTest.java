package com.javateam.TimeLabel.persistance;

import static org.junit.Assert.fail;

import java.sql.DriverManager;

import org.junit.Test;
import org.mariadb.jdbc.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCTest {
	
	private static Logger log = LoggerFactory.getLogger(JDBCTest.class);
	
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		log.info("jdbc 테스트");
		
		try(Connection con = 
				(Connection) DriverManager.getConnection(
				"jdbc:mariadb://javalec-sat.crwq4oaekhum.ap-northeast-2.rds.amazonaws.com:3306/sang_db",
				"sang",
				"sang1234")){
			System.out.println(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
}