package com.javateam.TimeLabel.service;

import java.util.List;

import com.javateam.TimeLabel.model.CartDTO;
import com.javateam.TimeLabel.model.CartVO;

public interface CartService {

	/* 장바구니 추가 */
	public int addCart(CartVO cart);

	/* 장바구니 정보 리스트 */
	public List<CartVO> getCartList(int userIndex);

	/* 카트 수량 수정 */
	public int modifyCount(CartVO cart);

	/* 카트 삭제 */
	public int deleteCart(int cartIndex);
	/* 카트 확인 */
	public CartVO checkCart(CartVO cart);
}