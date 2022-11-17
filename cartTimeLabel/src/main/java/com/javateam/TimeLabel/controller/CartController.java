package com.javateam.TimeLabel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.javateam.TimeLabel.model.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.javateam.TimeLabel.model.CartDTO;
import com.javateam.TimeLabel.model.UserVO;
import com.javateam.TimeLabel.service.CartService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Controller
@RequestMapping("/cart/*")
@Slf4j
public class CartController {

	@Autowired
	@Qualifier("cartService")
	private CartService cartService;

	/* 장바구니 추가 */
	/**
	 * 0: 등록 실패 1: 등록 성공 2: 등록된 데이터 존재 5: 로그인 필요
	 * 
	 */
	@PostMapping("/add")
	@ResponseBody
	public String addCartPOST(CartVO cart, HttpServletRequest request) {
		// 로그인 체크
		HttpSession session = request.getSession();
		UserVO uvo = (UserVO) session.getAttribute("user");
		if (uvo == null) {
			return "5";
		}

		// 카트 등록
		int result = cartService.addCart(cart);

		return result + "";
	}

	/* 장바구니 페이지 이동 */
	@RequestMapping(value = "/main/{userIndex}", method = RequestMethod.GET)
	public String cartPageGET(@Validated @PathVariable("userIndex") int userIndex,
			Model model) {
		log.info("CartPage go!");

		List<CartVO> cartList = cartService.getCartList(userIndex);

		model.addAttribute("cartInfo", cartList);
		log.info("cartvo:{}", cartList);
		return "user/cart";
	}

	/* 장바구니 수량 수정 */
	@PostMapping("/update")
	public String updateCartPOST(CartVO cart) {

		cartService.modifyCount(cart);

		return "redirect:user/cart/" + cart.getUserIndex();

	}

	/* 장바구니 수량 삭제 */
	@PostMapping("/delete")
	public String deleteCartPOST(CartVO cart) {

		cartService.deleteCart(cart.getCartIndex());

		return "redirect:user/cart/" + cart.getUserIndex();

	}

}