package com.javateam.TimeLabel.model;

import lombok.Data;

import java.sql.Date;

@Data
public class OrderVO {

    // 주문 번호
    private int orderIndex;
    // 유저 번호
    private int userIndex;

    private int totalPrice;
    // 주문 일자
    private Date orderDate;
    // 주문 메세지
    private String orderMessage;
    // order_state
    // private int orderStateIndex;

    // 주문 상태 번호
    private int orderStateIndex;
    // 상품 상태 정보
    private String orderStateInfo;









}
