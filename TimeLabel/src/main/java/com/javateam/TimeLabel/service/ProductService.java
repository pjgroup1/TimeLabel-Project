package com.javateam.TimeLabel.service;

import com.javateam.TimeLabel.model.ProductVO;
import com.javateam.TimeLabel.service.DTO.ProductUpdateServiceDTO;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {

    // 상품 등록
    void registration(ProductVO product) throws SQLException;
    // 상품 조회
    List<ProductVO> findProduct(Integer productIndex) throws SQLException;
    // 상품 전체 조회
    List<ProductVO> findAllProduct(ProductVO product) throws SQLException;
    // 상품 업데이트
    void productUpdate(@Param("productIndex")Integer productIndex, @Param("updateParam") ProductUpdateServiceDTO updateParam) throws SQLException;
    // 상품 삭제
    void productDelete(String productIndex) throws SQLException;
}
