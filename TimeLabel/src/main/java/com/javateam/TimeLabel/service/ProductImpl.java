package com.javateam.TimeLabel.service;

import com.javateam.TimeLabel.model.ProductVO;
import com.javateam.TimeLabel.mapper.ProductMapper;
import com.javateam.TimeLabel.service.DTO.ProductUpdateServiceDTO;
import com.javateam.TimeLabel.service.ProductService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductImpl implements ProductService {

    private ProductMapper productMapper;

    @Override
    public void registration(ProductVO product) {
         productMapper.registration(product);
    }

    @Override
    public List<ProductVO> findProduct(Integer productIndex) {
    	return productMapper.findProduct(productIndex);
    	
       
    }

    @Override
    public List<ProductVO> findAllProduct(ProductVO product) {
        return productMapper.findAllProduct(product);
    }

    @Override
    public void productUpdate(Integer productIndex, ProductUpdateServiceDTO updateParam) {
        productMapper.productUpdate(productIndex, updateParam);
    }

    @Override
    public void productDelete(String productIndex) {
        productMapper.productDelete(productIndex);
    }
}
