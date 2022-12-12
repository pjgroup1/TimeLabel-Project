package com.javateam.TimeLabel.service.impl;

import com.javateam.TimeLabel.mapper.OrderMapper;
import com.javateam.TimeLabel.model.CartVO;
import com.javateam.TimeLabel.model.OrderDetailVO;
import com.javateam.TimeLabel.model.OrderVO;
import com.javateam.TimeLabel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    @Qualifier("orderDAO")
    private OrderMapper orderMapper;


    // 주문 리스트
    @Override
    public List<OrderVO> orderList(int userIndex) {
        return orderMapper.orderList(userIndex);
    }

    // 주문 상세 리스트
    @Override
    public List<OrderDetailVO> orderDetailList(int orderIndex) {
        return orderMapper.orderDetailList(orderIndex);
    }

    @Override
    public void order(List<CartVO> cartList, String orderMessage) {
        orderMapper.order(cartList, orderMessage);
    }

    @Override
    public void orderDelete(int orderIndex) {
        orderMapper.orderDelete(orderIndex);

    }

    @Override
    public List<OrderVO> orderStateList() {
        return orderMapper.orderStateList();
    }

    @Override
    public void orderStateChange(OrderVO order) {
        orderMapper.orderStateChange(order);
    }
}
