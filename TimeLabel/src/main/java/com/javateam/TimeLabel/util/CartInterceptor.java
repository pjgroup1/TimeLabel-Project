package com.javateam.TimeLabel.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.javateam.TimeLabel.model.UserVO;

public class CartInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		
		UserVO user = (UserVO)session.getAttribute("loginUser");
		
		if(user == null) {
			
			response.sendRedirect("../user/login");
			
			return false;
			
		} else {
			
			return true;
			
		}		
		
	}

	
}