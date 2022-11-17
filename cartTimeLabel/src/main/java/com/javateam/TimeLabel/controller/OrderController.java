package com.javateam.TimeLabel.controller;

import com.javateam.TimeLabel.mapper.CartMapper;
import com.javateam.TimeLabel.mapper.ProductMapper;
import com.javateam.TimeLabel.model.OrderVO;
import com.javateam.TimeLabel.model.ProductVO;
import com.javateam.TimeLabel.model.UserVO;
import com.javateam.TimeLabel.model.session.SessionConst;
import com.javateam.TimeLabel.service.AdminService;
import com.javateam.TimeLabel.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private AdminService service;

    @Autowired
    private CartService cartService;


    @GetMapping("/main")
    public String orderList(int userIndex, HttpServletRequest request, Model model){
        log.info("order 페이지로 진입");
        log.info(">>>>>>>>>>>>>>>>>OrderPage>>>>>>>>>>>>>>>");
        UserVO userSession = (UserVO) request.getSession().getAttribute(SessionConst.LOGIN_USER);

        if (userSession == null) {
            return "user/login";
        }

        // log.info("userIndex={}, session={}", userIndex, session);
        model.addAttribute("cartList", cartService.getCartList(userSession.userIndex));

        return "order/main";
    }

}
