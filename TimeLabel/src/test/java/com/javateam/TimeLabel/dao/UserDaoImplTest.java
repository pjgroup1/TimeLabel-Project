package com.javateam.TimeLabel.dao;

import com.javateam.TimeLabel.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UserDaoImplTest {

    UserDaoImpl userDao = new UserDaoImpl();


    @Test
    public void selectUser() throws Exception{
        User user = new User();
        String str = "GILDONG";

        user = userDao.selectUser("GILDONG");

        assertTrue(user.getId().equals(str));
    }
}