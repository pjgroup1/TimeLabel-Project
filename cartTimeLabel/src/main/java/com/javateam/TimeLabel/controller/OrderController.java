package com.javateam.TimeLabel.controller;

import com.javateam.TimeLabel.model.UserVO;
import com.javateam.TimeLabel.model.session.SessionConst;
import com.javateam.TimeLabel.service.AdminService;
import com.javateam.TimeLabel.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    @Qualifier("adminService")
    private AdminService service;

    @Autowired
    @Qualifier("cartService")
    private CartService cartService;


    @GetMapping("/main")
    public String orderList(int userIndex, HttpServletRequest request, Model model){
        log.info("order 페이지로 진입");
        log.info(">>>>>>>>>>>>>>>>>OrderPage>>>>>>>>>>>>>>>");
        UserVO userSession = (UserVO) request.getSession().getAttribute(SessionConst.LOGIN_USER);

        if (userSession == null) {
            return "login";
        }

        // log.info("userIndex={}, session={}", userIndex, session);
        model.addAttribute("cartList", cartService.getCartList(userSession.userIndex));

        return "order/main";
    }

}
