package com.javateam.TimeLabel.service;

import com.javateam.TimeLabel.model.UserVO;
import com.javateam.TimeLabel.service.DTO.UserSearchDTO;
import com.javateam.TimeLabel.service.DTO.UserUpdateServiceDTO;

import java.util.List;

public interface UserService {


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
	 int userIdCheck(String userId);
	// 로그인
	 UserVO userLogin(UserVO user);

}
