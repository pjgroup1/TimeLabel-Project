package com.javateam.TimeLabel.mapper;

import com.javateam.TimeLabel.model.UserVO;

import java.util.List;


public interface UserMapper{
	
	// 회원 가입
	void userJoin(UserVO user);
	// 회원 조회
	UserVO findUser(String userId);
	// 회원 전체 조회
	List<UserVO> findAllUser(UserVO user);
	// 회원 수정
	void updateUser(UserVO user);
	// 회원 삭제
	void removeUser(String userId);
	// 아아디 중복 검사
	public int userIdCheck(String userId);
	// 로그인
	public UserVO userLogin(UserVO user);
	
	
}