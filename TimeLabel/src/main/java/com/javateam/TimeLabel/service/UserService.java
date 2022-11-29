package com.javateam.TimeLabel.service;

import com.javateam.TimeLabel.model.UserVO;

import java.util.List;

public interface UserService {


	// 회원 가입
	void userJoin(UserVO user);
	// 회원 조회
	UserVO findUser(int userIndex);
	// 회원 전체 조회
	List<UserVO> findAllUser();
	// 회원 수정
	void updateUser(UserVO user);
	// 회원 삭제
	void removeUser(int userIndex);
	// 아아디 중복 검사
	int userIdCheck(String userId);
	// 로그인
	 UserVO userLogin(UserVO user);
	// 비밀번호 찾기
	UserVO findPwUser(String userId);
	// 비밀번호 변경
	void changePw(UserVO user);
	// 이메일발송

}
