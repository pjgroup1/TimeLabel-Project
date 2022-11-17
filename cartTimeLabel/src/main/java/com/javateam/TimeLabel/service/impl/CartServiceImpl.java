package com.javateam.TimeLabel.service.impl;

import java.util.List;


import com.javateam.TimeLabel.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.javateam.TimeLabel.mapper.CartMapper;
import com.javateam.TimeLabel.model.CartVO;

@Service(value = "cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	@Qualifier("cartDAO")
	private CartMapper cartMapper;

	@Override
	public int addCart(CartVO cart) {

		// 장바구니 데이터 체크
		CartVO checkCart = cartMapper.checkCart(cart);

		if (checkCart != null) {
			return 2;
		}

		// 장바구니 등록 & 에러 시 0반환
		try {
			return cartMapper.addCart(cart);
		} catch (Exception e) {
			return 0;
		}

	}

	@Override
	public List<CartVO> getCartList(int userIndex) {

		List<CartVO> cart = cartMapper.getCartList(userIndex);

		return cart;

	}

	@Override
	public int modifyCount(CartVO cart) {

		return cartMapper.modifyCount(cart);
	}

	@Override
	public int deleteCart(int cartIndex) {

		return cartMapper.deleteCart(cartIndex);
	}

	@Override
	public CartVO checkCart(CartVO cart) {
		return null;
	}

}