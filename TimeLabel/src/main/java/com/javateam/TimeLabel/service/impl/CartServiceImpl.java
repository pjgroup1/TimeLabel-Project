package com.javateam.TimeLabel.service.impl;

import java.util.List;
import java.util.Map;


import com.javateam.TimeLabel.model.ProductVO;
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
	public void addCart(CartVO cart) throws Exception {
		cartMapper.addCart(cart);

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
	public int deleteCart(CartVO cart) {

		return cartMapper.deleteCart(cart);
	}

	@Override
	public CartVO checkCart(CartVO cart) {
		return null;
	}


	@Override
	public void individualCategoryList(int category, List<ProductVO> list) {
		if (category != 0) {
			for (int i = list.size() - 1; i >= 0; i--) {
				if (list.get(i).getProductCategoryIndex() != category) {
					list.remove(i);
				}
			}
		}
	}
}