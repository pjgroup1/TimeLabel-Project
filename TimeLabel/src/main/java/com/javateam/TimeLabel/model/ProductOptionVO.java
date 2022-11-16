package com.javateam.TimeLabel.model;

public class ProductOptionVO {

    // 상품 옵션 번호
    private Integer productOptionIndex;
    // 상품 번호
    private Integer productIndex;
    // 상품 사이즈
    private String productOptionValue;
    // 상품 상태(품절 or 판매중)
    private String productState;

    public ProductOptionVO() {
    }

    public ProductOptionVO(Integer productOptionIndex, Integer productIndex, String productOptionValue, String productState) {
        this.productOptionIndex = productOptionIndex;
        this.productIndex = productIndex;
        this.productOptionValue = productOptionValue;
        this.productState = productState;
    }

    public Integer getProductOptionIndex() {
        return productOptionIndex;
    }

    public void setProductOptionIndex(Integer productOptionIndex) {
        this.productOptionIndex = productOptionIndex;
    }

    public Integer getProductIndex() {
        return productIndex;
    }

    public void setProductIndex(Integer productIndex) {
        this.productIndex = productIndex;
    }

    public String getProductOptionValue() {
        return productOptionValue;
    }

    public void setProductOptionValue(String productOptionValue) {
        this.productOptionValue = productOptionValue;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    @Override
    public String toString() {
        return "ProductOptionVO{" +
                "productOptionIndex=" + productOptionIndex +
                ", productIndex=" + productIndex +
                ", productOptionValue='" + productOptionValue + '\'' +
                ", productState='" + productState + '\'' +
                '}';
    }
}
