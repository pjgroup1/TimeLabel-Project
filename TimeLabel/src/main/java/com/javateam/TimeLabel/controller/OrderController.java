package com.javateam.TimeLabel.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javateam.TimeLabel.model.CartVO;
import com.javateam.TimeLabel.model.OrderDetailVO;
import com.javateam.TimeLabel.model.OrderVO;
import com.javateam.TimeLabel.model.UserVO;
import com.javateam.TimeLabel.model.session.SessionConst;
import com.javateam.TimeLabel.service.AdminService;
import com.javateam.TimeLabel.service.OrderService;
import lombok.extern.slf4j.Slf4j;
//import org.apache.velocity.runtime.directive.Foreach;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    @Qualifier("adminService")
    private AdminService service;

    @Autowired
    @Qualifier("orderService")
    private OrderService orderService;

    // 결제 창
    @PostMapping("/payment")
    public String payment(HttpServletRequest request, Model model){
        log.info("payment ======= get ========>");
        UserVO loginUser = (UserVO) request.getSession().getAttribute(SessionConst.LOGIN_USER);
        String[] checks = request.getParameterValues("check");
        log.info("checksLength={}", checks.length);
        log.info("checks={}", Arrays.toString(checks));
        List<CartVO> cartList = new ArrayList<>();
        for (String check : checks) {
            CartVO cart = new CartVO();
            String number = check;
            log.info("number={}", number);
            log.info("request.getParameter CartIndex={}", request.getParameter("cartIndex" + number));
            cart.setCartIndex(Integer.parseInt(request.getParameter("cartIndex" + number)));
            cart.setProductName(request.getParameter("productName" + number));
            cart.setProductPrice(Integer.parseInt(request.getParameter("productPrice" + number)));
            cart.setProductIndex(Integer.parseInt(request.getParameter("productIndex" + number)));
            cart.setProductOptionValue(request.getParameter("productOptionValue" + number));
            cart.setProductThumbImage(request.getParameter("productThumbImage" + number));
            cart.setUserIndex(loginUser.getUserIndex());
            cart.setProductOptionIndex(Integer.parseInt(request.getParameter("productOptionIndex" 	+ number)));
            cart.setProductCount(Integer.parseInt(request.getParameter("productCount" + number)));
            cartList.add(cart);
            log.info("cartList={}", cart);
        }
        String orderMessage = request.getParameter("orderMessage");
        String discountPrice = request.getParameter("totalDiscountPrice");
        log.info("discountPrice={}",discountPrice);
        log.info("Controller = orderMessage={}", orderMessage);
        model.addAttribute("orderMessage", orderMessage);
        model.addAttribute("totalDiscountPrice", discountPrice);
        model.addAttribute("cartList", cartList);

        return "user/payment";
    }

    // 장바구니에서 바로결재재
   @GetMapping("/directAdd")
    public String directOrder(HttpServletRequest request, Model model){

        log.info("directAdd  ============== get ================>");

        UserVO loginUser = (UserVO) request.getSession().getAttribute(SessionConst.LOGIN_USER);
        List<CartVO> cartList = new ArrayList<>();
        for (int i=0; i<1; i++) {
            CartVO cart = new CartVO();
            String number = String.valueOf(i + 1);
            log.info("number={}", number);
            log.info("request.getParameter CartIndex={}", request.getParameter("cartIndex" + number));
            cart.setProductName(request.getParameter("productName" + number));
            cart.setProductPrice(Integer.parseInt(request.getParameter("productPrice" + number)));
            cart.setProductIndex(Integer.parseInt(request.getParameter("productIndex" + number)));
            cart.setProductOptionValue(request.getParameter("productOptionValue" + number));
            cart.setProductThumbImage(request.getParameter("productThumbImage" + number));
            cart.setUserIndex(loginUser.getUserIndex());
            cart.setProductOptionIndex(Integer.parseInt(request.getParameter("productOptionIndex" + number)));
            cart.setProductCount(Integer.parseInt(request.getParameter("productCount" + number)));
            cartList.add(cart);
            log.info("cartList={}", cart);
        }
        model.addAttribute("cartList", cartList);
        model.addAttribute("totalDiscountPrice", request.getParameter("discounted1"));
        String orderMessage = request.getParameter("orderMessage");
        log.info("Controller = orderMessage={}", orderMessage);
        return "user/payment";
    }


    // 주문하기
    @PostMapping("/add")
    public String orderAdd(HttpServletRequest request,
                           HttpSession session, int totalDiscountPrice,
                           Model model) {
        log.info("order Add !");
        UserVO loginUser = (UserVO) request.getSession().getAttribute(SessionConst.LOGIN_USER);
        List<CartVO> cartList = new ArrayList<>();
        int cartListSize = Integer.parseInt(request.getParameter("cartListSize"));
        log.info("cartListSize={}", cartListSize);
        CartVO cart = new CartVO();
        for (int i=0; i<cartListSize; i++) {
            String number = String.valueOf(i + 1);
            log.info("number={}", number);
            log.info("request.getParameter CartIndex={}", request.getParameter("cartIndex" + number));
            cart.setCartIndex(Integer.parseInt(request.getParameter("cartIndex" + number)));
            cart.setProductName(request.getParameter("productName" + number));
            cart.setProductPrice(Integer.parseInt(request.getParameter("productPrice" + number)));
            cart.setProductIndex(Integer.parseInt(request.getParameter("productIndex" + number)));
            cart.setProductOptionValue(request.getParameter("productOptionValue" + number));
            cart.setProductThumbImage(request.getParameter("productThumbImage" + number));
            cart.setUserIndex(loginUser.getUserIndex());
            cart.setProductOptionIndex(Integer.parseInt(request.getParameter("productOptionIndex" + number)));
            cart.setProductCount(Integer.parseInt(request.getParameter("productCount" + number)));
            cartList.add(cart);
            log.info("cartList={}", cart);
        }
        model.addAttribute("totalDiscountPrice", totalDiscountPrice);
        String orderMessage = request.getParameter("orderMessage");
        log.info("Controller = orderMessage={}", orderMessage);
        orderService.order(cartList, orderMessage);

        for(int i=0; i<cartListSize; i++){
            cartList.remove(cart);
        }
        return "redirect:/order/list";
    }


    @GetMapping("/list")
    public String order(HttpServletRequest request, Model model,
                        HttpSession session) {
        log.info(">>>>>>>>>>>>>>>>>OrderPage>>>>>>>>>>>>>>>");
        UserVO loginUser = (UserVO) request.getSession().getAttribute(SessionConst.LOGIN_USER);
        log.info("userSession find!!!!!={}", loginUser);

        int userIndex = loginUser.userIndex;
        log.info("userIndex={}", userIndex);
        List<OrderVO> orderList = orderService.orderList(userIndex);
        log.info("userOrder={}", orderList);

        model.addAttribute("orderList", orderList);
        log.info("orderList={}", model.getAttribute("orderList"));
        return "user/orderList";
    }

    @GetMapping("/detail/{orderIndex}")
    public String orderDetailPage(@PathVariable("orderIndex") int orderIndex,
                                  Model model){

        log.info("==== orderDetail page 진입 ====>");
        List<OrderVO> orderStateList = orderService.orderStateList();
        List<OrderDetailVO> orderDetails = orderService.orderDetailList(orderIndex);
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("orderStateList", JSONArray.fromObject(orderDetails));
        return "user/orderDetail";
    }

    @PostMapping("/orderStateChange")
    public String orderStateChange(@RequestParam("orderIndex") int orderIndex,
                                   @RequestParam("orderStateIndex") int orderStateIndex){
        OrderVO order = new OrderVO();
        log.info("배송 상태 변경 폼");
        order.setOrderIndex(orderIndex);
        order.setOrderStateIndex(orderStateIndex);
        log.info("OrderVO={}", order);

        orderService.orderStateChange(order);

        return "redirect:/admin/orderList";

    }


}
