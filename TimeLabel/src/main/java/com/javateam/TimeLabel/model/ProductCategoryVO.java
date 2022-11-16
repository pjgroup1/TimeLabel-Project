package com.javateam.TimeLabel.model;

public class ProductCategoryVO {
    // 카테고리 번호
    private Integer productCategoryIndex;
    // 카테고리 명
    private String productCategoryName;

    public Integer getProductCategoryIndex() {
        return productCategoryIndex;
    }

    public void setProductCategoryIndex(Integer productCategoryIndex) {
        this.productCategoryIndex = productCategoryIndex;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }


    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public ProductCategoryVO() {
    }

    public ProductCategoryVO(Integer productCategoryIndex, String productCategoryName) {
        this.productCategoryIndex = productCategoryIndex;
        this.productCategoryName = productCategoryName;
    }

    @Override
    public String toString() {
        return "ProductCategoryVO{" +
                "productCategoryIndex=" + productCategoryIndex +
                ", productCategoryName='" + productCategoryName + '\'' +
                '}';
    }
}
