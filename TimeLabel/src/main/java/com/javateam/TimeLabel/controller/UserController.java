package com.javateam.TimeLabel.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
public class UserController {
	
	
	@GetMapping("/loginm")
	public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
		return "login/loginForm";
	}
	
	@PostMapping
	public String loginAction(@Valid @ModelAttribute 
			LoginForm form, BindingResult bindingResult,
			HttpServletResponse response) {
		// BindingResult는 검증 오류가 발생할 경우 오류 내용을 보관하는 객체(스프링 제공)
		// @ModelAttribute 에 데이터 바인딩 시 오류가 발생해도 오류 정보를 FieldError 
		// 객체를 BindingResult가 담은 뒤 컨트롤러가 호출됨.
		if(bindingResult.hasErrors()) {
			// 에러 발생시 다시 로그인 화면으로 이동
			return "login/loginForm";
		}
		
		// 로그인 서비스 객체 생성. 변수에 담음
		// User loginUser = 서비스객체
		
		if(loginUser == null) {
			bindingResult.reject("loginFail", "아이디 또는 비밀번호가 다릅니다.");
			return "login.loginForm";
		}
		
		// 로그인 성공 처리
		
		Cookie idCookie = new Cookie("user_id", String.valueOf(loginUser.getId()));
		response.addCookie(idCookie);
		
		return "redirect:/";
		
	}

}
