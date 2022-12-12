package com.javateam.TimeLabel.service.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javateam.TimeLabel.mapper.ReviewMapper;
import com.javateam.TimeLabel.model.ReviewDTO;
import com.javateam.TimeLabel.model.ReviewPageDTO;

@Repository("reviewDAO")
public class ReviewDAOImpl implements ReviewMapper{
	
	@Autowired
	private SqlSession mybatis;
	
	// 매퍼
	private static String namespace = "com.javateam.TimeLabel.mapper.ReviewMapper";
	
	// 리뷰 등록
	@Override
	public int enrollReview(ReviewDTO dto) {
		return mybatis.insert(namespace + ".enrollReview", dto);
	}

	// 리뷰 체크
	@Override
	public Integer checkReview(ReviewDTO dto) {
		return mybatis.selectOne(namespace + ".checkReview", dto);
	}

	// 리뷰 조회
	@Override
	public List<ReviewDTO> getReviewList(ReviewPageDTO page) {
		return mybatis.selectList(namespace + ".getReviewList",page);
	}

	// 리뷰 전체
	@Override
	public int getReviewTotal(int productIndex) {
		return mybatis.selectOne(namespace + ".getReviewTotal", productIndex);
	}

	// 리뷰 수정
	@Override
	public int updateReview(ReviewDTO dto) {
		return mybatis.update(namespace + ".updateReview", dto);
	}

	@Override
	public ReviewDTO getUpdateReview(int reviewIndex) {
		return (ReviewDTO) mybatis.selectList(namespace + ".getUpdateReview", reviewIndex);
	}

	// 리뷰 삭제
	@Override
	public int deleteReview(int reviewIndex) {
		return mybatis.delete(namespace + ".deleteReview", reviewIndex);
	}
	

}
