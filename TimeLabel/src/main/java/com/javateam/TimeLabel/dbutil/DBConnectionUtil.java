package com.javateam.TimeLabel.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBConnectionUtil {

	
	@Autowired
	private ConnectionConst connectionConst;

	
	@Bean
	public DataSource dataSource() {
		// 커넥션 풀링
		HikariConfig config = new HikariConfig();
		
		config.setJdbcUrl(ConnectionConst.jdbcUrl);
		config.setUsername(ConnectionConst.username);
		config.setPassword(ConnectionConst.password);
		config.setMaximumPoolSize(10);
		config.setPoolName("Mypool");
		
		HikariDataSource dataSource = new HikariDataSource(config);
		
		return dataSource;

	}
	
	// DriverManager 을 사용하다 다른 커넥션 풀 이용시 코드 변경이 불가피
		/*
		 * public static Connection getConnection() { try { // 서버가 꺼져있으면 오류남 Connection
		 * connection = DriverManager.getConnection(ConnectionConst.URL,
		 * ConnectionConst.USERNAME, ConnectionConst.PASSWORD);
		 * log.info("get connection={}, class={}", connection, connection.getClass());
		 * return connection; }catch(SQLException e) { throw new
		 * IllegalStateException(e); } }
		 */
	
	
}
