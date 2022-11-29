package com.javateam.TimeLabel.controller;

import java.util.ArrayList;
import java.util.List;

import com.javateam.TimeLabel.model.ProductOptionVO;
import com.javateam.TimeLabel.model.ProductVO;
import com.javateam.TimeLabel.model.ReviewDTO;
import com.javateam.TimeLabel.model.ReviewPageDTO;
import com.javateam.TimeLabel.model.UserVO;
import com.javateam.TimeLabel.model.session.SessionConst;
import com.javateam.TimeLabel.service.AdminService;
import com.javateam.TimeLabel.service.CartService;
import com.javateam.TimeLabel.service.ReviewService;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    @Qualifier("adminService")
    AdminService adminService;

    @Autowired
    @Qualifier("reviewService")
    ReviewService reviewService;

    @Autowired
    @Qualifier("cartService")
    CartService cartService;

    /**
     * Simply selects the home view to render by returning its name.
     */
    // @GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpServletRequest request) {
        logger.info("환영합니다");
        // 세션이 아직 남은 상태에서 login창으로 들어갈려고 하면 main사이트로 갈수있도록함
        UserVO userSession = (UserVO) request.getSession().getAttribute(SessionConst.LOGIN_USER);
        log.info("session={}", userSession);
        if (userSession != null) {
            if (userSession.userIndex == 1) {
                return "admin/main";
            } else {
                return "redirect:/ProductList";
            }
        }
        return "login";
    }

    @RequestMapping(value = "/user/main", method = RequestMethod.GET)
    public String main() {
        logger.info("main page go!");

        return "redirect:/ProductList";
    }

    @RequestMapping(value = "/ProductList", method = RequestMethod.GET)
    public String ProductList(@RequestParam(value = "category", defaultValue = "0") int category, Model m)
            throws Exception {
        logger.info("#### 상품목록 페이지 이동 ####");

        List<ProductVO> list = adminService.productList();
        logger.info("list={}", list);
        logger.info("category={}", category);
        logger.info("#### 리스트 생성1 ####");
        m.addAttribute("itemlist", list);

        cartService.individualCategoryList(category, list);

        logger.info("#### 리스트 생성2 ####");

        return "user/ProductList";
    }

    @RequestMapping(value = "/ProductPage/{productIndex}", method = RequestMethod.GET)
    public String ProductPage(Model m, @PathVariable("productIndex") Integer productIndex, HttpServletRequest request,
                              @RequestParam(defaultValue = "1") int pageNum) throws Exception {
        logger.info("#### 상품 상세 페이지 이동 ####");

        ProductVO product = adminService.productView(productIndex);
        logger.info("================================= get Item =================================");
        m.addAttribute("item", product);
        logger.info("================================= item ={} ", product);

        List<ProductOptionVO> optionList = adminService.productOptionList(product.getProductCategoryIndex());
        logger.info("================================= get option ={}", optionList);
        ReviewPageDTO page = new ReviewPageDTO();
        page.setProductIndex(productIndex);
        page.setPage((pageNum - 1) * 10);
        List<ReviewDTO> reviews = (List<ReviewDTO>) reviewService.reviewList(page);
        m.addAttribute("reviewList", reviews);
        m.addAttribute("options", JSONArray.fromObject(optionList));

        int reviewCount = reviewService.reviewCount(productIndex);
        int lastPage = (int) Math.ceil(reviewCount / 10.0);
        log.info("lastpage : {}", lastPage);
        List<Integer> pageList = new ArrayList<>();
        int i = pageNum - 3;
        while (true) {
            if (++i < 1)
                continue;
            pageList.add(i);
            if (pageList.size() == 5 || i == lastPage)
                break;
        }
        m.addAttribute("pageNum", pageNum);
        m.addAttribute("pageList", pageList);
        m.addAttribute("lastPage", lastPage);
        return "user/ProductPage";
    }
}
