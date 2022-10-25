package com.javateam.TimeLabel.repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import com.javateam.TimeLabel.dto.Product;
import com.javateam.TimeLabel.dto.User;
import com.javateam.TimeLabel.repositoryImpl.UserRepository;
import com.javateam.TimeLabel.service.UserSearch;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

/**
 * JdbcTemplate 사용이유
 * 반복 문제를 해결 
 * JdbcTemplate은 템플릿 콜백 패턴을 사용해서, JDBC를 직접 사용할 때 발생하는 대부분의 반복작업을 대신 처리해준다.
 * 개발자는 SQL을 작성하고, 전달할 파라미터를 정의하고, 응답 값을 매핑하기만 하면 된다.
 * 우리가 생각할 수 있는 대부분의 반복 작업을 대신 처리해준다.
 * 	- 커넥션 획득, - statement 를 준비하고 실행, - 결과를 반복하도록 루프를 실행
 *  - 커넥션 종료, statement, ResultSet 종료
 *  - 트랜잭션 다루기 위한 커넥션 동기화
 *  - 예외 발생시 스프링 예외 변환기 실행
 */

/* public JdbcTemplate(DataSource dataSource) {
setDataSource(dataSource);
afterPropertiesSet(); }
 @param dataSource*/

@Slf4j
public class UserRepositoryImpl implements UserRepository{
	
	// spring에서 제공해주는 Jdbctemplate를 사용해서 반복되고 많은 코드량 줄일수 있음
	private final JdbcTemplate template;
	
	 
	@Autowired
	public UserRepositoryImpl(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	// 회원 가입
	@Override
	public User join(User user) {
		// 회원 가입 sql문
		// user_no 는 pk라 비워둬야함 데이터베이스가 직접 생성해줄 것임
		String sql = "insert into User(user_id, user_name, user_pw, user_mobile, user_email, user_birth, address, address_detail)"
				+ "values(?,?,?,?,?,?,?,?)";
		// 자동 증가값 no를 가져오기 위해 사용
		KeyHolder keyHolder = new GeneratedKeyHolder();
		// KeyHolder 와 connection.prepareStatement(sql, new String[]{"user_no"}) 를 사용해서 지정해주면
		// insert 쿼리 실행 이후에 데이터베이스에 생성된 no 값을 조회할 수 있다.
		
		template.update(connection ->{
			// update(String sql, @Nullable Object... args) - 생성.업데이트.삭제 모두 update
			// 자동 증가 키
			PreparedStatement ps = connection.prepareStatement(sql, new String[]{"user_no"});
			ps.setString(1, user.getUser_id());
			ps.setString(2, user.getUser_name());
			ps.setString(3, user.getUser_pw());
			ps.setString(4, user.getUser_mobile());
			ps.setString(5, user.getUser_email());
			ps.setDate(6, user.getUser_birth());
			ps.setString(7, user.getAddress());
			ps.setString(8, user.getAddress_detail());
			return ps;
		}, keyHolder);
		// 키값을 꺼낼수 있게됨
		long key = keyHolder.getKey().longValue();
		// 키 값을 넣어줌
		user.setUser_no(key);
		return user;
	}
	
	// 회원 조회
	@Override
	public Optional<User> findById(Long user_no) {
		// 회원 조회 sql문
		String sql = "select user_id, user_name, user_mobile, address, address_detail from user where user_no=?";
		// queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args) 
		
		try{
			// .queryForObject 하나의 값만 찾을때 사용함 하나 이상일때 .query 사용 (밑에도 query 사용 가능함)
			User user = template.queryForObject(sql, userRowMapper(), user_no);
			return Optional.of(user);
		}catch(EmptyResultDataAccessException e){
			// 데이터가 안들어 왔을시
			return Optional.empty();
		}
			
	}
	
	// 전체 회원 조회
	@Override
	public List<User> findAll(UserSearch userSearch) {
		
		String user_id = userSearch.getUser_id();
		String user_name = userSearch.getUser_name();
		String user_mobile = userSearch.getUser_mobile();
		String user_email = userSearch.getUser_email();
		String address = userSearch.getAddress();
		String address_detatil = userSearch.getAddress_detail();
		
				
		String sql = "select user_id, user_name, user_mobile, user_email, , address, address_detatil from user";		
		// 동적 쿼리
		if(StringUtils.hasText(user_id) || user_name != null) {
			sql += " where";
		}
		
		
		/**
		 * query 인터페이스
		 * <T> List<T> query(String sql, RowMapper<T> rowMapper, Obeject....args) throws DataAccessException
		 */
		return template.query(sql, userRowMapper());
	}
	
	// 회원 수정
	@Override
	public void update(Long user_no, User updateParam) {
		// 회원 수정  sql문
		String sql = "update user set user_pw=?, user_mobile=?, address=?, address_detail=? where user_no=?";
		// 위의 sql과 순서가 틀리지 않게 주의
		template.update(sql, 
				updateParam.getUser_pw(),
				updateParam.getUser_mobile(),
				updateParam.getAddress(),
				updateParam.getAddress_detail(),
				user_no);
	}
	
	// 회원 삭제
	@Override
	public void delete(String user_id) {
		// 회원 삭제 sql문
		String sql ="delete from user where user_id=?";
		template.update(sql, user_id);
		
	}
	
	// 회원 찾기를 위한 맵퍼
	/**
	 * 데이터베이스의 조회 결과를 객체로 변환할 때 사용된다.
	 * RowMapper 는 데이터베이스의 반환 결과인 ResultSet 을 객체로 변환한다.
	 * 결과가 없으면 컬렉션을 반환한다.
	 */
	private RowMapper<User> userRowMapper(){
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
