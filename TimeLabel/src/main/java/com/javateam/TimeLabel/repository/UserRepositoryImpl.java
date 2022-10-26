package com.javateam.TimeLabel.repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
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
@Repository
public class UserRepositoryImpl implements UserRepository{
	
	// spring에서 제공해주는 Jdbctemplate를 사용해서 반복되고 많은 코드량 줄일수 있음
	// 그냥 JdbcTemplate 사용시 쿼리문가 값을 같은 순서로 넣어야하는데 NamedParameter은 그런 번거러움에서 벗어날수 있음
	private final NamedParameterJdbcTemplate template;
	// insert에서만 사용 다른 코드들은 큰관계없음
	private final SimpleJdbcInsert jdbcInsert;
	
	 
	@Autowired
	public UserRepositoryImpl(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcInsert = new SimpleJdbcInsert(dataSource)
				.withTableName("user") // 데이터를 저장할 테이블명 지정
				.usingGeneratedKeyColumns("user_no"); // key를 생성하는 PK컬럼 명을 지정
				// .usingColumns(columnNames); 생략가능~
	}
	
	// 회원 가입
	@Override
	public User join(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		Number key = jdbcInsert.executeAndReturnKey(param);
		user.setUser_no(key.longValue());
		return user;
	}
	
	// 회원 수정
		@Override
		public void update(Long user_no, User updateParam) {
			// 회원 수정  sql문
			String sql = "update user set user_pw=:user_pw, user_mobile=:user_mobile,"
					+ " address=:address, address_detail=:address_detail where user_no=:user_no";
			SqlParameterSource param = new MapSqlParameterSource()
					.addValue("user_pw", updateParam.getUser_pw())
					.addValue("user_mobile", updateParam.getUser_mobile())
					.addValue("address", updateParam.getAddress())
					.addValue("address_detail", updateParam.getAddress_detail());
			// 위의 sql과 순서가 틀리지 않게 주의
			template.update(sql, param);
		}
	
	// 회원 조회
	@Override
	public Optional<User> findById(Long user_no) {
		// 회원 조회 sql문
		String sql = "select user_id, user_name, user_mobile, address, address_detail from user where user_no=:user_no";
		// queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args) 
		
		try{
			Map<String, Object> param = Map.of("user_no", user_no);
			// .queryForObject 하나의 값만 찾을때 사용함 하나 이상일때 .query 사용 (밑에도 query 사용 가능함)
			User user = template.queryForObject(sql, param ,userRowMapper());
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
		
		SqlParameterSource param = new BeanPropertySqlParameterSource(userSearch);	
		String sql = "select user_id, user_name, user_mobile, user_email, , address, address_detatil from user";			
		
		/**
		 * query 인터페이스
		 * <T> List<T> query(String sql, RowMapper<T> rowMapper, Obeject....args) throws DataAccessException
		 */
		return template.query(sql, param, userRowMapper());
	}
	
	
	
	// 회원 삭제
	@Override
	public void delete(Long user_no) {
		// 회원 삭제 sql문
		String sql ="delete from user where user_no=?";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user_no);	
		template.update(sql, param);
		
	}
	
	// 회원 찾기를 위한 맵퍼
	/**
	 * 데이터베이스의 조회 결과를 객체로 변환할 때 사용된다.
	 * RowMapper 는 데이터베이스의 반환 결과인 ResultSet 을 객체로 변환한다.
	 * 결과가 없으면 컬렉션을 반환한다.
	 */
	private RowMapper<User> userRowMapper(){
		// Result set을 사용해서 User 객체를 다넣어줌
		// BeanPropertyRowMapper 는 언더스코어 표기법을 카멜로 자동 변환해준다.
		// 따라서 setUser_name 으로 조회해도 setUserName() 으로 들어가짐
      return BeanPropertyRowMapper.newInstance(User.class);
    }

	

}
