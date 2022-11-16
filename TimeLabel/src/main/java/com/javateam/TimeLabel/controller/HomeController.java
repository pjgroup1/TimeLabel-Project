package com.javateam.TimeLabel.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.javateam.TimeLabel.model.ProductVO;
import com.javateam.TimeLabel.model.UserVO;
import com.javateam.TimeLabel.model.session.SessionConst;
import com.javateam.TimeLabel.service.AdminService;
import com.javateam.TimeLabel.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import static sun.security.ssl.SSLLogger.info;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	AdminService adminService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// @GetMapping("/")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		logger.info("환영합니다");
		// 세션이 아직 남은 상태에서 login창으로 들어갈려고 하면 main사이트로 갈수있도록함
		UserVO loginUser = (UserVO) request.getSession().getAttribute(SessionConst.LOGIN_USER);

		log.info("session={}", loginUser);
		if(loginUser != null){
			if(loginUser.userIndex == 1){
				return "admin/main";
			}else{
				return "user/main";
			}
		}
		return "user/login";
	}
	
	@RequestMapping(value = "/user/main", method = RequestMethod.GET)
	public String main() {
		logger.info("main page go!");

		return "user/main";
	}

	@RequestMapping(value="/ProductList", method = RequestMethod.GET)
	public String ProductList(Model m) throws Exception{
		logger.info("#### 상품목록 페이지 이동 ####");

		List<ProductVO> list = adminService.productList();
		logger.info("list:{}",list);
		logger.info("#### 리스트 생성1 ####");
		m.addAttribute("itemlist", list);

		logger.info("#### 리스트 생성2 ####");

		return "ProductList";
	}

	@RequestMapping(value="/ProductPage", method = RequestMethod.GET)
	public String ProductPage(Model m, Integer productIndex) throws Exception{
		logger.info("#### 상품 상세 페이지 이동 ####");

		ProductVO list = adminService.productView(productIndex);
		logger.info("#### item리스트 생성1 ####");
		m.addAttribute("item", list);
		logger.info("#### item리스트 생성2 ####");

		return "ProductPage";
	}
}
