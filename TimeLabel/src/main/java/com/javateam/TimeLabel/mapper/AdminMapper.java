package com.javateam.TimeLabel.mapper;

import java.util.List;

import com.javateam.TimeLabel.model.ProductCategoryVO;
import com.javateam.TimeLabel.model.ProductOptionVO;
import com.javateam.TimeLabel.model.ProductVO;

public interface AdminMapper {

	// 카테고리
	public List<ProductCategoryVO> category() throws Exception;

	// 상품등록
	public void register(ProductVO vo) throws Exception;

	// 상품목록
	public List<ProductVO> productList() throws Exception;

	// 상품조회  + 카테고리 조인
	public ProductVO productView(int productIndex) throws Exception;

	//상품옵션 조회
	public List<ProductOptionVO> productOptionList(int productIndex) throws Exception;
	// 상품 수정
	public void productModify(ProductVO vo) throws Exception;

	// 상품 삭제
	public void productDelete(int productIndex) throws Exception;

//	// 주문 목록
//	public List<OrderVO> orderList() throws Exception;
//
//	// 특정 주문 목록
//	public List<OrderListVO> orderView(OrderVO order) throws Exception;

//	// 배송 상태
//	public void delivery(OrderVO order) throws Exception;
//
//	// 상품 수량 조절
//	public void changeStock(GoodsVO goods) throws Exception;
//
//	// 모든 소감(댓글)
//	public List<ReplyListVO> allReply() throws Exception;
//
//	// 소감(댓글) 삭제
//	public void deleteReply(int repNum) throws Exception;
} 