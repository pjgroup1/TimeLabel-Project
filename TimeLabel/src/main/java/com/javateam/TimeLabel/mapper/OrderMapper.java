package com.javateam.TimeLabel.mapper;

import com.javateam.TimeLabel.model.CartVO;
import com.javateam.TimeLabel.model.OrderDetailVO;
import com.javateam.TimeLabel.model.OrderVO;

import java.util.List;


public interface OrderMapper {

    // 주문 리스트
    List<OrderVO> orderList(int userIndex);

    // 주문 상세 리스트
    List<OrderDetailVO> orderDetailList(int orderIndex);

    // 주문
    void order(List<CartVO> cartList, String orderMessage);

    // 주문 삭제
    void orderDelete(int orderIndex);

    // 상품페이지 에서 바로 구매
    void directOrder(List<CartVO> cartList, String orderMessage);

    // 주문 옵션 정보만 가져오기
    List<OrderVO> orderStateList();

    // 배송정보 옵션 바꾸기
    void orderStateChange (OrderVO order);
}
