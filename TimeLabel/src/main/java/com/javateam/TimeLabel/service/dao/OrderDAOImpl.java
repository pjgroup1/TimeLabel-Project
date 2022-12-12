package com.javateam.TimeLabel.service.dao;

import com.javateam.TimeLabel.mapper.OrderMapper;
import com.javateam.TimeLabel.model.CartVO;
import com.javateam.TimeLabel.model.OrderDetailVO;
import com.javateam.TimeLabel.model.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository("orderDAO")
public class OrderDAOImpl implements OrderMapper {

	@Autowired
	private SqlSession mybatis;

	private static final String nameSpace = "com.javateam.TimeLabel.mapper.OrderMapper";

	// 주문 리스트
	@Override
	public List<OrderVO> orderList(int userIndex) {
		log.info("orderList Create !!!!!!!!!!!!!!!!!!!!!={}", mybatis.selectList(nameSpace + ".orderList", userIndex));
		return mybatis.selectList(nameSpace + ".orderList", userIndex);
	}

	// 주문 상세 리스트
	@Override
	public List<OrderDetailVO> orderDetailList(int orderIndex) {
		return mybatis.selectList(nameSpace + ".orderDetailList", orderIndex);
	}

	// 주문
	@Override
	public void order(List<CartVO> cartList, String orderMessage) {
		OrderVO order = new OrderVO();
		order.setUserIndex(cartList.get(0).getUserIndex());
		order.setOrderMessage(orderMessage);
		log.info("orderMessage={}", orderMessage);
		mybatis.insert(nameSpace + ".order", order);
		mybatis.insert(nameSpace + ".orderDetail", cartList);
		for(CartVO cart : cartList)
			mybatis.delete("com.javateam.TimeLabel.mapper.CartMapper.deleteCart", cart);
	}

	@Override
	public void directOrder(List<CartVO> cartList, String orderMessage) {
		OrderVO order = new OrderVO();
		order.setUserIndex(cartList.get(0).getUserIndex());
		order.setOrderMessage(orderMessage);
		log.info("orderMessage={}", orderMessage);
		mybatis.insert(nameSpace + ".order", order);
		mybatis.insert(nameSpace + ".orderDetail", cartList);
	}

	@Override
	public List<OrderVO> orderStateList() {
		return mybatis.selectList(nameSpace + ".orderState");
	}

	@Override
	public void orderStateChange(OrderVO order) {
		mybatis.update(nameSpace + ".orderStateChange", order);
	}

	@Override
	public void orderDelete(int orderIndex) {
		mybatis.delete(nameSpace + ".orderDelete", orderIndex);
	}
}
