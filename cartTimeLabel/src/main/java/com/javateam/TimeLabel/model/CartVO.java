package com.javateam.TimeLabel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartVO {

	// 카트 번호
	private int cartIndex;
	// 회원 아이디
	private int userIndex;
	// 상품 옵션 번호
	private Integer productOptionIndex;
	// 상품 구매 수량
	private Integer productCount;

	// product 상품
	// 상품 카테고리 이름
	private String productCategoryName;
	// 상품 이름
	private String productName;
	// 상품 옵션 값
	private Integer productOptionValue;
	// 상품 가격
	private Integer productPrice;

	// 추가
	// 상품 할인가
	private Integer discountedPrice;
	// 상품 메인이미지
	private String productMainImage;
	// 상품 썸네일 이미지
	private String productThumbImage;
}
