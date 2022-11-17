package com.javateam.TimeLabel.mapper;

import com.javateam.TimeLabel.model.UserVO;
import com.javateam.TimeLabel.service.DTO.UserSearchDTO;
import com.javateam.TimeLabel.service.DTO.UserUpdateServiceDTO;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface UserMapper{
	
	// 회원 가입
	void userJoin(UserVO user);
	// 회원 조회
	UserVO findUser(String userId);
	// 회원 전체 조회
	List<UserVO> findAllUser(UserSearchDTO userSearch);
	// 회원 수정
	void updateUser(UserUpdateServiceDTO updateParam);
	// 회원 삭제
	void removeUser(String userId);
	// 아아디 중복 검사
	public int userIdCheck(String userId);
	// 로그인
	public UserVO userLogin(UserVO user);
	
	
}