package com.javateam.TimeLabel.service.DTO;

public class CartDTO {
	
	// 카트 번호
	private Integer cartIndex;
	// 회원 아이디
	private Integer userIndex;
	// 상품 옵션 번호
	private Integer productOptionIndex;
	// 상품 구매 수량
	private Integer productCount;
    
    // product 상품
    private String productCategoryName;
    
    private String productName;
    
    private Integer productOptionValue;
	
    private Integer productPrice;
    
    // 추가
    private Integer discountedPrice;
    
    private String productMainImage;
    
    private String productThumbImage;

	public Integer getCartIndex() {
		return cartIndex;
	}

	public void setCartIndex(Integer cartIndex) {
		this.cartIndex = cartIndex;
	}

	public Integer getUserIndex() {
		return userIndex;
	}

	public void setUserIndex(Integer userIndex) {
		this.userIndex = userIndex;
	}

	public Integer getProductOptionIndex() {
		return productOptionIndex;
	}

	public void setProductOptionIndex(Integer productOptionIndex) {
		this.productOptionIndex = productOptionIndex;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductOptionValue() {
		return productOptionValue;
	}

	public void setProductOptionValue(Integer productOptionValue) {
		this.productOptionValue = productOptionValue;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Integer discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public String getProductMainImage() {
		return productMainImage;
	}

	public void setProductMainImage(String productMainImage) {
		this.productMainImage = productMainImage;
	}

	public String getProductThumbImage() {
		return productThumbImage;
	}

	public void setProductThumbImage(String productThumbImage) {
		this.productThumbImage = productThumbImage;
	}

	@Override
	public String toString() {
		return "CartDTO [cartIndex=" + cartIndex + ", userIndex=" + userIndex + ", productOptionIndex="
				+ productOptionIndex + ", productCount=" + productCount + ", productCategoryName=" + productCategoryName
				+ ", productName=" + productName + ", productOptionValue=" + productOptionValue + ", productPrice="
				+ productPrice + ", discountedPrice=" + discountedPrice + ", productMainImage=" + productMainImage
				+ ", productThumbImage=" + productThumbImage + "]";
	}

	
	
    
		 
}