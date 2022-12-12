package com.javateam.TimeLabel.model;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewDTO {

	// 리뷰 번호
	private int reviewIndex;
	// 고객 번호
	private int userIndex;
	// 리뷰 작성일자
	private Date reviewDate;
	// 리뷰 제목
	private String reviewTitle;
	// 리뷰 내용
	private String reviewContent;
	// 상품 번호
	private int productIndex;
	// 상품 이름
	private String productName;
	// 유저 아이디
	private String userID;
	
}
