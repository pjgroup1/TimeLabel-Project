package com.javateam.TimeLabel.service;

import com.javateam.TimeLabel.model.OrderVO;

import java.util.List;

public interface OrderService {

    // 주문 리스트
    List<OrderVO> orderList(OrderVO order, int userIndex);

    // 주문 상세 리스트
    List<OrderVO> orderDetailList(OrderVO order, int userIndex);

    // 주문
    void order(OrderVO order);
    // 주문 삭제
    void orderDelete(int orderIndex);
    // 주문 (카트 -> List<CartVO> items forEach문 사용해서 한개씩뺌)

}
