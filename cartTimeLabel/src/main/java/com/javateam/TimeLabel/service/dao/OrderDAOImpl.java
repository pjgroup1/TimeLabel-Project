package com.javateam.TimeLabel.service.dao;

import com.javateam.TimeLabel.mapper.OrderMapper;
import com.javateam.TimeLabel.model.OrderVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDAOImpl implements OrderMapper {
    @Autowired
    private SqlSession session;

    private static final String nameSpace = "com.javateam.TimeLabel.domain.OrderVO";

    // 주문 리스트
    @Override
    public List<OrderVO> orderList(OrderVO order, int userIndex) {
        return session.selectList(nameSpace + ".orderList", order);
    }

    // 주문 상세 리스트
    @Override
    public List<OrderVO> orderDetailList(OrderVO order, int userIndex) {
        return session.selectList(nameSpace + ".orderDetailList", order);
    }

    @Override
    public void order(OrderVO order) {
        session.insert(nameSpace + ".order", order);
    }

    @Override
    public void orderDelete(int orderIndex) {
        session.delete(nameSpace + ".orderDelete", orderIndex);
    }
}
