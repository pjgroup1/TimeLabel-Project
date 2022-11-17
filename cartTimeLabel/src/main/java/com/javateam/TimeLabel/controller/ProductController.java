package com.javateam.TimeLabel.controller;


import com.javateam.TimeLabel.model.ProductVO;
import com.javateam.TimeLabel.validation.ProductValidation;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;

@Slf4j
@RequestMapping("/product")
public class ProductController {

    @Autowired
    // private ProductService productService;

    private final ProductValidation productValidation;

    public ProductController(ProductValidation productValidation) {
        this.productValidation = productValidation;
    }

    // private static final Logger Logger = LoggerFactory.getLogger(ProductController.class);

    @InitBinder // InitBinder 컨트롤러에만 영향을 줌 글로벌 설정은 별도로 해야함
    public void init(WebDataBinder dataBinder) {
        // WebDataBinder 에 검증기를 추가하면 해당 컨트롤러에서는 검증기를 자동으로 적용할 수 있다.
        // == 요청이 들어올때마다 검증해줌
        dataBinder.addValidators(productValidation);
    }


    // 상품 등록 폼으로 이동
    @GetMapping("/add")
    public String item(@ModelAttribute ProductVO product) {
        log.info("상품 이동폼으로 이동");
        return "Product/add";
    }

    // 상품 등록
    /*@PostMapping("/add")
    public String addItem(@Validated @ModelAttribute ProductVO product,
                          BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        log.info("상품 등록 페이지 로 이동");
        // @Validated ==> 검증이 끝나고 그 결과를 bindingResult 담아줌 (검증기를 실행하는 어노테이션)
        // 검증 실패시 발생
        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            // model.addAttribute("errors", errors); bindingResult는 자동으로 model에 담겨 넘어감
            return "product/add";
        }

        // 성공 로직
        try {
            productService.registration(product);
        } catch (SQLException e) {
            log.info("error", e);
        }
        redirectAttributes.addAttribute("productIndex", product.getProductIndex());
        redirectAttributes.addAttribute("status", true);
        log.info("상품 등록 완료");
        return "redirect:/product/{productIndex}";
    }
*/
    // 상품 조회
    @GetMapping("/productList")
    public String productList() {
        return "";
    }

    // 상품 전체 조회
    @GetMapping("/productAllList")
    public String productAllList() {
        return "";
    }
}
