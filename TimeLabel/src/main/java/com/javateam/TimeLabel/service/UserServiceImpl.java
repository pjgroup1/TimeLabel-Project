package com.javateam.TimeLabel.service;

import com.javateam.TimeLabel.model.UserVO;
import com.javateam.TimeLabel.mapper.UserMapper;
import com.javateam.TimeLabel.service.DTO.UserSearchDTO;
import com.javateam.TimeLabel.service.DTO.UserUpdateServiceDTO;
import com.javateam.TimeLabel.service.UserService;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SqlSession session;

    @Override
    public void userJoin(UserVO user) {
         userMapper.userJoin(user);
    	// session.insert("com.javateam.TimeLabel.mapper.UserMapper.userJoin", user);
    }

    @Override
    public UserVO findUser(String userId) {
         return userMapper.findUser(userId);
    }

    @Override
    public List<UserVO> findAllUser(UserSearchDTO userSearch) {
       List<UserVO> allUser = userMapper.findAllUser(userSearch);
        return allUser;
    }

    @Override // parameter 2개 이상부터는 @Param을 지정해주어야함
    public void updateUser(UserUpdateServiceDTO updateParam) {
        userMapper.updateUser(updateParam);
    }

    // 아이디 삭제
    @Override
    public void removeUser(String userId) {
        userMapper.removeUser(userId);
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
}
