package com.javateam.TimeLabel.service.dao;

import com.javateam.TimeLabel.mapper.OrderMapper;
import com.javateam.TimeLabel.model.OrderVO;
import com.javateam.TimeLabel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    private static final String nameSpace = "com.javateam.TimeLabel.domain.OrderVO";

    // 주문 리스트
    @Override
    public List<OrderVO> orderList(OrderVO order, int userIndex) {
        return orderMapper.orderList(order, userIndex);
    }

    // 주문 상세 리스트
    @Override
    public List<OrderVO> orderDetailList(OrderVO order, int userIndex) {
        return orderMapper.orderDetailList(order, userIndex);
    }

    @Override
    public void order(OrderVO order) {
        orderMapper.order(order);
    }

    @Override
    public void orderDelete(int orderIndex) {
        orderMapper.orderDelete(orderIndex);

    }
}
