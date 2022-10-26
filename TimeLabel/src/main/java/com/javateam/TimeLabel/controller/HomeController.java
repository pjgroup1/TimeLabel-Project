package com.javateam.TimeLabel.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javateam.TimeLabel.dto.User;
import com.javateam.TimeLabel.repository.UserRepositoryImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {
	
	private UserRepositoryImpl userRepositoryImpl;
	
	@GetMapping("/")
	public String home() {
		return "login";
	}
	@GetMapping("/join.do")
	public String joina() {
		return "join";
	}
	
	// @GetMapping("/")
	public String homeLogin(@CookieValue(name="user_no", required = false) Long user_id, Model model) {
		
		if(user_id == null) {
			return "home";
		}
		
		// 로그인
		User loginUser = userRepositoryImpl.findById(user_no);
		if(loginUser == null) {
			// 값이 없을시
			return "home";
		}
		model.addAttribute("user", loginUser);
		
		// 로그인 페이지로 이동
		return "loginHome";
	}
	
	// 로그아웃
	@PostMapping("/logout")
	public String logout(HttpServletResponse response) {
		expireCookie(response, "user_id");
		
		// 로그아웃시 홈화면으로 이동
		return "redirect:/";
	}
	
	private void expireCookie(HttpServletResponse response, String cookieName) {
		Cookie cookie = new Cookie(cookieName, null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
}
