package com.javateam.TimeLabel.model;

import lombok.Data;

import java.sql.Date;

@Data
public class OrderDetailVO {

    // 주문 번호
    private int orderIndex;
    // 상품 번호
    private int productIndex;
    // 상품 이름
    private String productName;
    // 주문 상세 번호
    private int orderDetailIndex;
    // 상품 옵션 값
    private String productOptionValue;
    // 쌈네일
    private String productThumbImage;
    // 상품 수량
    private int productCount;
    // 상품 금액
    private int productPrice;
}
