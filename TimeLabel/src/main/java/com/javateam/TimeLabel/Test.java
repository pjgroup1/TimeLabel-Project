package com.javateam.TimeLabel;

import com.javateam.TimeLabel.dao.UserDaoImpl;
import com.javateam.TimeLabel.domain.User;

public class Test {
    public static void main(String args[]){
        try {
            System.out.println(test());
            System.out.println("good2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String test() throws Exception{
        User user = new User();
        UserDaoImpl userDao = new UserDaoImpl();

        System.out.println("good");
        user = userDao.selectUser("GILDONG");
        String str = user.getId();
        return str;
    }
}
