package com.javateam.TimeLabel.service.impl;

import com.javateam.TimeLabel.model.UserVO;
import com.javateam.TimeLabel.mapper.UserMapper;
import com.javateam.TimeLabel.service.MailService;
import com.javateam.TimeLabel.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDAO")
    private UserMapper userMapper;



    // @Autowired
    // private SqlSession session;

    @Override
    public void userJoin(UserVO user) {
         userMapper.userJoin(user);
    	// session.insert("com.javateam.TimeLabel.mapper.UserMapper.userJoin", user);
    }

    @Override
    public UserVO findUser(int userIndex) {
         return userMapper.findUser(userIndex);
    }

    @Override
    public List<UserVO> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override // parameter 2개 이상부터는 @Param을 지정해주어야함
    public void updateUser(UserVO user) {
        userMapper.updateUser(user);
    }

    // 아이디 삭제
    @Override
    public void removeUser(int userIndex) {
        userMapper.removeUser(userIndex);
    }

    // 아이디 중복 체크
    @Override
    public int userIdCheck(String userId) {
       return userMapper.userIdCheck(userId);
    }

    // 로그인
    @Override
    public UserVO userLogin(UserVO user) {
        // String userId, String userPw
	/*return userMapper.findUser(userId)
			.filter(u -> u.getUserPw().equals(userPw))
			.orElse(null);*/
        return userMapper.userLogin(user);
    }

    @Override
    public UserVO findPwUser(String userId) {
        return userMapper.findPwUser(userId);
    }

    @Override
    public void changePw(UserVO user) {
        userMapper.changePw(user);
    }
}
