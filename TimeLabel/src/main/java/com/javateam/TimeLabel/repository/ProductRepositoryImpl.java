package com.javateam.TimeLabel.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import com.javateam.TimeLabel.dto.Product;
import com.javateam.TimeLabel.repositoryImpl.ProductRepository;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;
import net.sf.log4jdbc.sql.resultsetcollector.JdbcUtils;

@Slf4j
public class ProductRepositoryImpl implements ProductRepository {

	private final JdbcTemplate template;
	
	
	// private final DataSource dataSource;
	@Autowired
	public ProductRepositoryImpl(DataSource dataSource) {
		// this.dataSource = dataSource;
		this.template = new JdbcTemplate(dataSource);
	}

	// 상품 등록
	@Override
	public Product registration(Product product) {
		String sql = "insert into Product(product_index, product_name, product_price, product_state, product_rep_image, product_date, product_info, product_quantity) "
				+ "values (?,?,?,?,?,?,?,?,)";
		template.update(sql, product.getProduct_index(), product.getProduct_name(), product.getProduct_price(),
				product.getProduct_state(), product.getProduct_rep_image(), product.getProduct_date(),
				product.getProduct_info(), product.getProduct_quantity());
		return product;
	}

	// 상품 조회
	@Override
	public Product findProduct(String product_index) {
		String sql = "select * from product where product_index=?";
		return template.queryForObject(sql, productRowMapper(), product_index);
	}

	private RowMapper<Product> productRowMapper() {
		return (rs, rowNum) -> {
			// 밑에 숫자 만큼 반복
			Product product = new Product();
			product.setProduct_index(rs.getString("product_index"));
			product.setProduct_name(rs.getString("product_name"));
			product.setProduct_price(rs.getString("product_price"));
			product.setProduct_state(rs.getString("product_state"));
			product.setProduct_rep_image(rs.getString("product_rep_image"));
			product.setProduct_date(rs.getDate("product_date"));
			product.setProduct_info(rs.getString("product_info"));
			product.setProduct_quantity(rs.getString("product_quantity"));
			// ResultSet으로 먼저 값을 받아서 Product객체에 담아서 반환
			return product;
		};

	}

	// 상품 수정
	@Override
	public void productUpdate(String product_index, String product_name, String product_price, String product_state,
			String product_rep_image, String product_info, String product_quantity) {
		String sql = "update product set product_name=?, product_price=?, product_state=?, product_rep_image=?, product_info=?, product_quantity=?";
		template.update(sql, product_name, product_price, product_state, product_rep_image, product_info,
				product_quantity);
	}

	// 상품 삭제
	@Override
	public void productDelete(String product_index) {
		String sql = "delete from product where product_index=?";
		template.update(sql, product_index);

	}

	/*
	 * private Connection getConnection() throws SQLException { Connection con =
	 * dataSource.getConnection(); log.info("get connection={}, class={}"); return
	 * con; }
	 */

// JdbcUtils 편의 기능
	/*
	 * public void close(Connection con, Statement stmt, ResultSet rs) {
	 * org.springframework.jdbc.support.JdbcUtils.closeResultSet(rs);
	 * org.springframework.jdbc.support.JdbcUtils.closeStatement(stmt);
	 * org.springframework.jdbc.support.JdbcUtils.closeConnection(con); }
	 */

	/*boolean andFlag = false;
	List<Object> param = new ArrayList<>();
	if(StringUtils.hasText(user_id)) {
		// ?안에 값이 들어간 것에  포함된 모든 문자열을 검색후 문자열을 합쳐줌
		// concat (문자열 합치기)
		sql += " user_id like concat('%',?,'%')";
		param.add(user_id);
		andFlag = true;
	}
	
	if(user_name != null) {
		if(andFlag) {
			sql += " and";
		}
		sql += " price <= ?";
		param.add(user_name);
	}
	log.info("sql={}", sql);*/
}
