package com.javateam.TimeLabel.repositoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.javateam.TimeLabel.dto.Product;
import com.javateam.TimeLabel.dto.User;
import com.javateam.TimeLabel.service.UserSearch;


public interface UserRepository{
	
	// 회원 가입
	User join(User user);
	// 회원 조회
	Optional<User> findById(Long user_no);
	// 회원 전체 조회
	List<User> findAll(UserSearch userSearch);
	// 회원 수정
	void update(Long user_no, User updateParam);
	// 회원 삭제
	void delete(Long user_no);
	
	
}