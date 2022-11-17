package com.javateam.TimeLabel.service.impl;

import java.util.List;

import com.javateam.TimeLabel.model.ProductCategoryVO;
import com.javateam.TimeLabel.model.ProductVO;
import com.javateam.TimeLabel.service.AdminService;
import com.javateam.TimeLabel.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	@Qualifier(("adminDAO"))
	private AdminMapper dao;

	// 카테고리
	@Override
	public List<ProductCategoryVO> category() throws Exception {
		return dao.category();
	}

	// 상품등록
	@Override
	public void register(ProductVO vo) throws Exception {
		dao.register(vo);		
	}

	// 상품목록
	@Override
	public List<ProductVO> productList() throws Exception {
		return dao.productList();
	}

	// 상품조회  + 카테고리 조인
	@Override
	public ProductVO productView(int productIndex) throws Exception {
		return dao.productView(productIndex);
	}

	// 상품 수정
	@Override
	public void productModify(ProductVO vo) throws Exception {
		dao.productModify(vo);
	}

	// 상품 삭제
	@Override
	public void productDelete(int productIndex) throws Exception {
		dao.productDelete(productIndex);
	}

//	// 주문 목록
//	@Override
//	public List<OrderVO> orderList() throws Exception {
//		return dao.orderList();
//	}
//
//	// 특정 주문
//	@Override
//	public List<OrderListVO> orderView(OrderVO order) throws Exception {
//		return dao.orderView(order);
//	}
//
//	// 배송 상태
//	@Override
//	public void delivery(OrderVO order) throws Exception {
//		dao.delivery(order);
//	}
//
//	// 상품 수량 조절
//	@Override
//	public void changeStock(GoodsVO goods) throws Exception {
//		dao.changeStock(goods);
//	}
//
//	// 모든 소감(댓글)
//	@Override
//	public List<ReplyListVO> allReply() throws Exception {
//		return dao.allReply();
//	}
//
//	// 소감(댓글) 삭제
//	@Override
//	public void deleteReply(int repNum) throws Exception {
//		dao.deleteReply(repNum);
//	}
}