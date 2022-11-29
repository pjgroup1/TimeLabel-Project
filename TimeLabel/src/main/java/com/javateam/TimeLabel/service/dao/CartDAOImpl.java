package com.javateam.TimeLabel.service.dao;

import com.javateam.TimeLabel.mapper.CartMapper;
import com.javateam.TimeLabel.model.CartVO;
import com.javateam.TimeLabel.model.ProductVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("cartDAO")
public class CartDAOImpl implements CartMapper {

    @Autowired
    private SqlSession session;

    private static final String nameSpace = "com.javateam.TimeLabel.mapper.CartMapper";
    @Override
    public void addCart(CartVO cart) {
        session.insert(nameSpace + ".addCart", cart);
    }

    @Override
    public int deleteCart(CartVO cart) {
        return session.delete(nameSpace + ".deleteCart", cart);
    }

    @Override
    public int modifyCount(CartVO cart) {
        return session.update(nameSpace + ".modifyCount", cart);
    }

    @Override
    public List<CartVO> getCartList(int userIndex) {
        return session.selectList(nameSpace + ".getCartList", userIndex);
    }

    @Override
    public CartVO checkCart(CartVO cart) {
        return session.selectOne(nameSpace + ".checkCart", cart);
    }

}
