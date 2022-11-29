package com.javateam.TimeLabel.service;

import java.util.List;

import com.javateam.TimeLabel.model.ReviewDTO;
import com.javateam.TimeLabel.model.ReviewPageDTO;

public interface ReviewService {

	/* 댓글 등록 */
	public int enrollReview(ReviewDTO dto);	
	
	/* 댓글 존재 체크 */
	public String checkReview(ReviewDTO dto);	
	
	/* 댓글 페이징 */
	public List<ReviewDTO> reviewList(ReviewPageDTO page);	
	
	/* 리뷰 총 개수*/
	public int reviewCount(int productIndex);
	
	/* 댓글 수정 */
	public int updateReview(ReviewDTO dto);	
	
	/* 댓글 한개 정보(수정페이지) */
	public ReviewDTO getUpdateReview(int reviewIndex);	
	
	/* 댓글 삭제 */
	public int deleteReview(ReviewDTO dto);		
	
	
	
	
}