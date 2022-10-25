package com.javateam.TimeLabel.repositoryImpl;

import com.javateam.TimeLabel.dto.Product;

public interface ProductRepository{
	
	// 상품 등록
	Product registration(Product product);
	// 상품 조회
	Product findProduct(String product_index);
	// 상품 업데이트
	void productUpdate(String product_index, String product_name, String product_price, String product_state, String product_rep_image, String product_info, String product_quantity);
	// 상품 삭제
	void productDelete(String product_index);
}
