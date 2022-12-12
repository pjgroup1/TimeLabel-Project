package com.javateam.TimeLabel.model;

public class CartDTO {

	// 유저 번호
	private int USER_INDEX;
	// 상품 옵션 번호
	private int PRODUCT_OPTION_INDEX;

    
    // product 상품
    // 상품 가격
    private int PRODUCT_PRICE;
    // 상품 총수량
    private int PRODUCT_COUNT;
    
    // 추가
	// 상품 할인가격
    private int SalePrice;
    // 총 가격
    private int TotalPrice;
    
    
    public int getUSER_INDEX() {
		return USER_INDEX;
	}

	public void setUSER_INDEX(int USER_INDEX) {
		this.USER_INDEX = USER_INDEX;
	}

	public int getPRODUCT_OPTION_INDEX() {
		return PRODUCT_OPTION_INDEX;
	}

	public void setPRODUCT_OPTION_INDEX(int PRODUCT_OPTION_INDEX) {
		this.PRODUCT_OPTION_INDEX = PRODUCT_OPTION_INDEX;
	}

	public int getPRODUCT_COUNT() {
		return PRODUCT_COUNT;
	}

	public void setPRODUCT_COUNT(int PRODUCT_COUNT) {
		this.PRODUCT_COUNT = PRODUCT_COUNT;
	}

	public int getSalePrice() {
		return SalePrice;
	}

	public int getTotalPrice() {
		return TotalPrice;
	}
	
	// 할인가와 총값의 변수  초기화
	public void initSaleTotal() {
		this.SalePrice = (int) (this.PRODUCT_PRICE * (1-this.PRODUCT_COUNT));
		this.TotalPrice = this.SalePrice*this.PRODUCT_COUNT;
	}

	@Override
	public String toString() {
		return "CartDTO [USER_INDEX=" + USER_INDEX + ", PRODUCT_OPTION_INDEX=" + PRODUCT_OPTION_INDEX + ", PRODUCT_PRICE=" + PRODUCT_COUNT
				+ ", PRODUCT_COUNT=" + PRODUCT_COUNT + ", SalePrice=" + SalePrice + ", TotalPrice=" + TotalPrice + "]";
	}
    
}