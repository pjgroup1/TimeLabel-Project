package com.javateam.TimeLabel.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.javateam.TimeLabel.controller.AdminController;
import com.javateam.TimeLabel.model.UserVO;
import com.javateam.TimeLabel.model.session.SessionConst;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest req,
				HttpServletResponse res, Object obj) throws Exception {

		HttpSession session = req.getSession();
		UserVO user = (UserVO)session.getAttribute(SessionConst.LOGIN_USER);

		if(user == null) {
			res.sendRedirect("/user/login");
			logger.info("로그인을 해야 관리자 페이지에 접속할 수 있습니다");
			return false;
		}


		if(user.userIndex!=1) {
			logger.info("관리자만 관리자 페이지에 접속할 수 있습니다.");
			res.sendRedirect("/user/main");
			return false;
		}
		
		return true;
	}
}