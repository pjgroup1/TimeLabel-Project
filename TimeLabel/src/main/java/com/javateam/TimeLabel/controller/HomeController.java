package com.javateam.TimeLabel.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/")
	public String home() {
		logger.info("환영합니다");
		
		return "login";
	}
	
	@GetMapping("/join.do")
	public String join() {
		logger.info("회원가입");
		
		return "join";
	}
	
	@GetMapping("/joinPro")
	public String joinPro() {
		logger.info("회원가입 폼");
		
		return "joinPro";
	}
	
	@GetMapping("/UserMain")
	public String UserMain() {
		logger.info("사용자 메인화면");
		
		return "UserMain";
	}
	
	@GetMapping("/UserTop")
	public String UserTop() {
		logger.info("상단바");
		
		return "UserTop";
	}
	
	@GetMapping("/CartView")
	public String CartView() {
		logger.info("장바구니");
		
		return "CartView";
	}
	
	@GetMapping("/logout")
	public String logout() {
		logger.info("로그아웃");
		
		return "logout";
	}
	
}
