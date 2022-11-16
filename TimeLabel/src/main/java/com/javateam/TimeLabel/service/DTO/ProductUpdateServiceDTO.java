package com.javateam.TimeLabel.service.DTO;

import java.sql.Date;

public class ProductUpdateServiceDTO {

    // 상품 카테고리 번호
    private String productCategoryIndex;
    // 상품 이름
    private String productName;
    // 상품 가격
    private Integer productPrice;
    // 상품 상태(ex 판매중, 품절)
    private String productState;
    // 상품 대표 이미지
    private String productMainImage;
    // 상품 이미지
    private String productImage1;
    private String productImage2;
    private String productImage3;
    // 상품 등록일
    private Date productDate;
    // 상품 정보
    private String productInfo;
    // 상품 수량
    private Integer productQuantity;

    @Override
    public String toString() {
        return "ProductUpdateServiceDTO{" +
                "productCategoryIndex='" + productCategoryIndex + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productState='" + productState + '\'' +
                ", productMainImage='" + productMainImage + '\'' +
                ", productImage1='" + productImage1 + '\'' +
                ", productImage2='" + productImage2 + '\'' +
                ", productImage3='" + productImage3 + '\'' +
                ", productDate=" + productDate +
                ", productInfo='" + productInfo + '\'' +
                ", productQuantity=" + productQuantity +
                '}';
    }

    public ProductUpdateServiceDTO(String productCategoryIndex, String productName, Integer productPrice, String productState, String productMainImage, String productImage1, String productImage2, String productImage3, Date productDate, String productInfo, Integer productQuantity) {
        this.productCategoryIndex = productCategoryIndex;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productState = productState;
        this.productMainImage = productMainImage;
        this.productImage1 = productImage1;
        this.productImage2 = productImage2;
        this.productImage3 = productImage3;
        this.productDate = productDate;
        this.productInfo = productInfo;
        this.productQuantity = productQuantity;
    }

    public ProductUpdateServiceDTO() {
    }
}
