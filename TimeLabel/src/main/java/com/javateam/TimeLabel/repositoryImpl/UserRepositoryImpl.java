package com.javateam.TimeLabel.repositoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javateam.TimeLabel.dto.User;
 
public interface UserRepositoryImpl {
	
	// 회원 가입
	User join(User user);
	// 회원 조회
	User findById(String user_id);
	// 회원 수정
	void update(String user_id, String user_pw, String user_mobile, String address, String address_detail);
	// 회원 삭제
	void delete(String user_id);
}