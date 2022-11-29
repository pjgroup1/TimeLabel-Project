package com.javateam.TimeLabel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.javateam.TimeLabel.mapper.ReviewMapper;
import com.javateam.TimeLabel.model.ReviewDTO;
import com.javateam.TimeLabel.model.ReviewPageDTO;
import com.javateam.TimeLabel.service.ReviewService;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	@Qualifier("reviewDAO")
	private ReviewMapper reviewMapper;
	
	/* 댓글등록 */
	@Override
	public int enrollReview(ReviewDTO dto) {
		
		int result = reviewMapper.enrollReview(dto);
		
		return result;
	}
	
	
	/* 댓글 존재 체크 */
	@Override
	public String checkReview(ReviewDTO dto) {
		
		Integer result = reviewMapper.checkReview(dto);
		
		if(result == null) {
			
			return "0";
			
		} else {
			
			return "1";
			
		}
		
	}	
	
	@Override
	public List<ReviewDTO> reviewList(ReviewPageDTO page) {
		return reviewMapper.getReviewList(page);
	}	
	
	@Override
	public int updateReview(ReviewDTO dto) {
		
		int result = reviewMapper.updateReview(dto); 
		
		return result;
		
	}	
	
	@Override
	public ReviewDTO getUpdateReview(int reviewIndex) {
		
		return reviewMapper.getUpdateReview(reviewIndex);
	}	
	
	@Override
	public int deleteReview(ReviewDTO dto) {
		
		int result = reviewMapper.deleteReview(dto.getReviewIndex()); 	
		
		return result;
	}


	@Override
	public int reviewCount(int productIndex) {
		return reviewMapper.getReviewTotal(productIndex);
	}		
	

}