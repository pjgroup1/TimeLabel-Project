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
    public UserVO findUser(String userId) {
        return session.selectOne(nameSpace + ".findUser", userId);
    }

    @Override
    public List<UserVO> findAllUser(UserVO user) {
        return session.selectList(nameSpace + ".finaAllUser", user);
    }

    @Override
    public void updateUser(UserVO user) {
        session.update(nameSpace + ".updateUser", user);
    }

    @Override
    public void removeUser(String userId) {
        session.delete(nameSpace + ".removeUser", userId);
    }

    @Override
    public int userIdCheck(String userId) {
        int result = session.selectOne(nameSpace + ".userIdCheck", userId);
        return result;
    }

    @Override
    public UserVO userLogin(UserVO user) {
        return session.selectOne(nameSpace + ".userLogin", user);
    }
}
