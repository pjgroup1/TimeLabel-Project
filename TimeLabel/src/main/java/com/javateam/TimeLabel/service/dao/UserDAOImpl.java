package com.javateam.TimeLabel.service.dao;

import com.javateam.TimeLabel.mapper.UserMapper;
import com.javateam.TimeLabel.model.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDAO")
public class UserDAOImpl implements UserMapper {

    @Autowired
    private SqlSession session;

    private static final String nameSpace = "com.javateam.TimeLabel.mapper.UserMapper";
    @Override
    public void userJoin(UserVO user) {
        session.insert(nameSpace + ".userJoin", user);
    }

    @Override
    public UserVO findUser(int userIndex) {
        return session.selectOne(nameSpace + ".findUser", userIndex);
    }

    @Override
    public List<UserVO> findAllUser() {
        return session.selectList(nameSpace + ".findAllUser");
    }

    @Override
    public void updateUser(UserVO user) {
        session.update(nameSpace + ".updateUser", user);
    }

    @Override
    public void removeUser(int userIndex) {
        session.delete(nameSpace + ".removeUser", userIndex);
    }

    @Override
    public int userIdCheck(String userId) {
        return session.selectOne(nameSpace + ".userIdCheck", userId);

    }

    @Override
    public UserVO userLogin(UserVO user) {
        return session.selectOne(nameSpace + ".userLogin", user);
    }

    @Override
    public UserVO findPwUser(String userId) {
        return session.selectOne(nameSpace + ".findPwUser", userId);
    }

    @Override
    public void changePw(UserVO user) {
       session.update(nameSpace + ".changePw", user);
    }
}
