package com.javateam.TimeLabel.model;

import lombok.Data;

import java.sql.Date;

@Data
public class OrderVO {

    // 주문 번호
    private int orderIndex;
    // 유저 번호
    private int userIndex;
    // 주문 상세 번호
    private int orderStateIndex;
    // 주문 일자
    private Date orderDate;
    // 주문 메세지
    private String orderMessage;

    // order_detail
    // private int orderIndex;
    // 주문 상세 번호
    private int orderDetailIndex;
    // 상품 옵션 번호
    private int productOptionIndex;
    // 상품 수량
    private int productCount;
    // 총 금액
    private int subTotalPrice;

    // order_state
    // private int orderStateIndex;
    // 상품 상태 정보
    private String orderStateInfo;

    // 데이터 베이스에서 가져올 값들
    // 상품 이름
    private String productName;







}
