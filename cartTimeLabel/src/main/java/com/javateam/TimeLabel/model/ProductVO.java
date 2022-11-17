package com.javateam.TimeLabel.model;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


// 상품 DTO

@Data
public class ProductVO {
	// 상품 번호
	private Integer productIndex;
	// 상품 카테고리 번호
	private String productCategoryIndex;
	// 상품 이름
	private String productName;
	// 상품 가격
	private Integer productPrice;
	// 상품 상태(ex 판매중, 품절)
	private String productState;
	// 상품 대표 이미지
	private String productMainImage;
	// 상품 세일 퍼센트
	private int productDiscount;
	// 상품 이미지
	private String productThumbImage;
	// 상품 등록일
	private Date productDate;
	// 상품 정보
	private String productInfo;
	// 상품 수량
	private Integer productQuantity;
	

	
}
