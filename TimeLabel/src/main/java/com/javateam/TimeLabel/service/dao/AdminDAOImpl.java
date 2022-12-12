package com.javateam.TimeLabel.service.dao;

import java.util.List;

import javax.inject.Inject;

import com.javateam.TimeLabel.mapper.AdminMapper;
import com.javateam.TimeLabel.model.ProductCategoryVO;
import com.javateam.TimeLabel.model.ProductOptionVO;
import com.javateam.TimeLabel.model.ProductVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminMapper {

	@Autowired
	private SqlSession sql;

	// 매퍼
	private static String namespace = "com.javateam.TimeLabel.mappers.adminMapper";

	// 카테고리
	@Override
	public List<ProductCategoryVO> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}

	// 상품등록
	@Override
	public void register(ProductVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}

	// 상품목록
	@Override
	public List<ProductVO> productList() throws Exception {
		return sql.selectList(namespace + ".productList");
	}

	// 상품조회 + 카테고리 조인
	@Override
	public ProductVO productView(int productIndex) throws Exception {
		return sql.selectOne(namespace + ".productView", productIndex);
	}

	// 상품 수정
	@Override
	public void productModify(ProductVO vo) throws Exception {
		sql.update(namespace + ".productModify", vo);
	}

	// 상품 삭제
	@Override
	public void productDelete(int productIndex) throws Exception {
		sql.delete(namespace + ".productDelete", productIndex);
	}

	//상품옵션 조회
	@Override
	public List<ProductOptionVO> productOptionList(int productIndex) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".productOptionList", productIndex);
	}

//	// 상품 수량 조절
//	@Override
//	public void changeQuantity(ProductVO quantity) throws Exception {
//		sql.update(namespace + ".changeStock", product);
//	}

//	// 주문 목록
//	@Override
//	public List<OrderVO> orderList() throws Exception {
//		return sql.selectList(namespace + ".orderList");
//	}
//
//	// 특정 주문 목록
//	@Override
//	public List<OrderListVO> orderView(OrderVO order) throws Exception {
//		return sql.selectList(namespace + ".orderView", order);
//	}
//
//	// 배송 상태
//	@Override
//	public void delivery(OrderVO order) throws Exception {
//		sql.update(namespace + ".delivery", order);
//	}


//	// 모든 소감(댓글)
//	@Override
//	public List<ReplyListVO> allReply() throws Exception {
//		return sql.selectList(namespace + ".allReply");
//	}
//
//	// 소감(댓글) 삭제
//	@Override
//	public void deleteReply(int repNum) throws Exception {
//		sql.delete(namespace + ".deleteReply", repNum);
//	}
} 