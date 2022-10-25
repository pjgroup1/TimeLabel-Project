package com.javateam.TimeLabel.dao;

import com.javateam.TimeLabel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

@Repository
public class UserDaoImpl {
//    ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml"); // xml 경로
//    DataSource ds = ac.getBean(DataSource.class);

    @Autowired
    DataSource ds;

    public User selectUser(String id) throws Exception{
        User user = null;
        String sql = "SELECT * FROM USER WHERE user_id= ? ";

//        Class.forName("org.mariadb.jdbc.Driver");		// jdbc 연결
//        String DB_URL = "jdbc:mariadb://javalec-sat.crwq4oaekhum.ap-northeast-2.rds.amazonaws.com:3306/sang_db";
//        String userName="sang";
//        String password="sang1234";

        try (
//                Connection conn = DriverManager.getConnection(DB_URL, userName, password);
                Connection conn = ds.getConnection();  // datasource bean 주입 jdbc 연결
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery(); //  select

            if (rs.next()) {
                user = new User();
                user.setId(rs.getString(2));
            }
        }
        return user;
    }

//    public int insertUser(User user) throws Exception {
//        String sql = "INSERT INTO USER VALUES (?,?,?,?,?,?, now()) ";
//
//        try(
//                Connection conn = ds.getConnection();
//                PreparedStatement pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상
//        ){
//            pstmt.setString(2, user.getId());
//            pstmt.setString(3, user.getPw());
//            pstmt.setString(4, user.getName());
//            pstmt.setString(5, user.getEmail());
////            pstmt.setDate(6, new java.sql.Date(user.getBirth().getTime()));
////            pstmt.setString(7, user.getSns());
//
//            return pstmt.executeUpdate();
//        }
//    }
}
