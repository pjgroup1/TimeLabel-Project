package com.javateam.TimeLabel.repository;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.javateam.TimeLabel.dto.User;
import com.javateam.TimeLabel.repositoryImpl.UserRepositoryImpl;

public class UserRepository implements UserRepositoryImpl{
	
	// spring에서 제공해주는 Jdbctemplate를 사용해서 반복되고 많은 코드량 줄일수 있음
	private final JdbcTemplate template;
	/**
	 * public JdbcTemplate(DataSource dataSource) {
		setDataSource(dataSource);
		afterPropertiesSet(); }
	 * @param dataSource
	 */
	public UserRepository(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	// 회원 가입
	@Override
	public User join(User user) {
		// 회원 가입 sql문
		String sql = "insert into User(user_id, user_name, user_pw, user_mobile, user_email, user_birth, address, address_detail)"
				+ "values(?,?,?,?,?,?,?,?)";
		// update(String sql, @Nullable Object... args)
		template.update(sql, 
				user.getUser_id(), user.getUser_name(), user.getUser_pw(), 
				user.getUser_mobile(), user.getUser_email(), user.getUser_birth(),
				user.getAddress(), user.getAddress_detail() );
		return user;
	}
	
	// 회원 조회
	@Override
	public User findById(String user_id) {
		// 회원 조회 sql문
		String sql = "select * from user where user_id=?";
		// queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args) 
		return template.queryForObject(sql, memberRowMapper(), user_id);
	}
	
	// 회원 수정
	@Override
	public void update(String user_id, String user_pw, String user_mobile, String address, String address_detail) {
		// 회원 수정  sql문
		String sql = "update user set user_pw=?, user_mobile=?, address=?, address_detail=? where user_id=?";
		template.update(sql, user_pw, user_mobile, address, address_detail);
	}
	
	// 회원 삭제
	@Override
	public void delete(String user_id) {
		// 회원 삭제 sql문
		String sql ="delete from user where user_id=?";
		template.update(sql, user_id);
		
	}
	
	// 회원 찾기를 위한 맵퍼
	private RowMapper<User> memberRowMapper(){
        return (rs, rowNum) -> {
            User user = new User();
            user.setUser_id(rs.getString("user_id"));
            user.setUser_name(rs.getString("user_name"));
            user.setUser_pw(rs.getString("user_pw"));
            user.setUser_email(rs.getString("user_email"));
            user.setUser_mobile(rs.getString("user_mobile"));
            user.setUser_birth(rs.getDate("user_birth"));
            user.setAddress(rs.getString("address"));
            user.setAddress_detail(rs.getString("address_detail"));
            user.setUser_date(rs.getDate("user_date"));
            return user;
        };
    }

}
