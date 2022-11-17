package com.javateam.TimeLabel.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javateam.TimeLabel.model.UserVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/spring/root-context.xml")
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void userJoin() {
		UserVO user = new UserVO();
		// 변수 선언 및 초기화
		user.setUserId("아이디1");
		user.setUserPw("비밀번호1");
		user.setUserName("이름1");
		user.setUserContact("번호1");
		user.setUserEmail("이메일1");
		user.setUserZip("우편주소1");
		user.setUserAddress("주소1");
		user.setUserAddressDetail("상세주소1");
		
		userMapper.userJoin(user);
		
	}

	// 로그인 쿼리 테스트
	@Test
	public void userLogin() {
		UserVO user = new UserVO();
		// 변수 선언 및 초기화

		// 맞는 아이디와 비밀번호
		user.setUserId("test1");
		user.setUserPw("test1");

		// 다른 아이디와 비밀번호 일때
		// user.setUserId("test12");
		// user.setUserPw("test132");

		userMapper.userLogin(user);
		System.out.println("결과 : " + userMapper.userLogin(user));

	}
}
