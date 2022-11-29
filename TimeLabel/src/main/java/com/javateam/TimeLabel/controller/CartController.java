package com.javateam.TimeLabel.controller;

import javax.servlet.http.HttpServletRequest;

import com.javateam.TimeLabel.model.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.javateam.TimeLabel.model.UserVO;
import com.javateam.TimeLabel.model.session.SessionConst;
import com.javateam.TimeLabel.service.CartService;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
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
	public String addCartPOST(CartVO cart, HttpServletRequest request) throws Exception {
		log.info("cart:{}",cart);
		UserVO loginUser=(UserVO) request.getSession().getAttribute(SessionConst.LOGIN_USER);
		cart.setUserIndex(loginUser.userIndex);
		// 카트 등록
		cartService.addCart(cart);
		return "redirect:../ProductList";
	}

	/* 장바구니 페이지 이동 */
	@RequestMapping(value = "/main/{userIndex}", method = RequestMethod.GET)
	public String cartPageGET(@Validated @PathVariable("userIndex") int userIndex,
							  Model model) {
		log.info("CartPage go!");

		List<CartVO> cartList = cartService.getCartList(userIndex);

		log.info("userindex:{}",userIndex);
		model.addAttribute("cartInfo", cartList);
		log.info("cartInfo={}", cartList);
		return "user/cart";
	}

	/* 장바구니 수량 수정 */
	@PostMapping("/update")
	public String updateCartPOST(CartVO cart, HttpServletRequest request) {

		cartService.modifyCount(cart);

		return "redirect:user/cart/" + cart.getUserIndex();

	}

	/* 장바구니 수량 삭제 */
	@ResponseBody
	@GetMapping(value="/delete", produces="text/plain;  charset=UTF-8")
	public String deleteCartGet(HttpServletRequest request,
							  @RequestParam(value="check[]") List<String> checkArr,
							  CartVO cart) {
		log.info("카트 아이템 삭제");
		UserVO loginUser = (UserVO) request.getSession().getAttribute(SessionConst.LOGIN_USER);
		int userIndex = loginUser.getUserIndex();
		int result = 0;
		int cartNum = 0;
		// 로그인이 되어있을시 실행
		if (loginUser != null) {
			// 카트에 유저 번호를 넣어줌
			cart.setUserIndex(userIndex);
			for(String i : checkArr){
				// ajax로 checkArr(checkArr안에 카트 번호를 넣어줬음)을 받아와 i변수에 하나씩 넣어줌
				cartNum = Integer.parseInt(i);
				// 유저번호, 카트번호를 넣은후 delete
				cart.setCartIndex(cartNum);
				cartService.deleteCart(cart);
			}
			result = 1;
		}
		return String.valueOf(result);
	}

}