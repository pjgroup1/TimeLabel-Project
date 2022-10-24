package com.javateam.TimeLabel.dto;

import java.sql.Date;

import lombok.Data;

@Data
// 상품 DTO
public class Product {
	// 상품 번호
	private String product_index;
	// 상품 카테고리 번호
	private String product_category_index;
	// 상품 이름
	private String product_name;
	// 상품 가격
	private String product_price;
	// 상품 상태(ex 판매중, 품절)
	private String product_state;
	// 상품 대표 이미지
	private String product_rep_image;
	// 상품 등록일
	private Date product_date;
	// 상품 정보
	private String product_info;
	// 상품 수량
	private String product_quantity;
	
}
