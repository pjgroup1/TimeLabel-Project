package com.javateam.TimeLabel.model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductOptionVO {

    // 상품 옵션 번호
    private Integer productOptionIndex;
    // 상품 번호
    private Integer productCategoryIndex;
    // 상품 사이즈
    private String productOptionValue;
    // 상품 상태(품절 or 판매중)
    private String productState;

}
