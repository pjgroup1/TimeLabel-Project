package com.javateam.TimeLabel.mapper;

import com.javateam.TimeLabel.model.OrderVO;
import org.springframework.context.annotation.Configuration;

import java.util.List;


public interface OrderMapper {

    // 주문 리스트
    List<OrderVO> orderList(OrderVO order, int userIndex);

    // 주문 상세 리스트
    List<OrderVO> orderDetailList(OrderVO order, int userIndex);

    // 주문
    void order(OrderVO order);

    // 주문 삭제
    void orderDelete(int orderIndex);

}
