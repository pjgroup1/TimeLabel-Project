package com.javateam.TimeLabel.mapper;

import java.util.List;

import com.javateam.TimeLabel.model.ReviewDTO;
import com.javateam.TimeLabel.model.ReviewPageDTO;

public interface ReviewMapper {

	/* 댓글 등록 */
	public int enrollReview(ReviewDTO dto);	
	
	/* 댓글 존재 체크 */
	public Integer checkReview(ReviewDTO dto);	
	
	/* 댓글 페이징 */
	public List<ReviewDTO> getReviewList(ReviewPageDTO page);
	
	/* 댓글 총 갯수(페이징) */
	public int getReviewTotal(int productIndex);	
	
	/* 댓글 수정 */
	public int updateReview(ReviewDTO dto);	
	
	/* 댓글 한개 정보(수정페이지) */
	public ReviewDTO getUpdateReview(int reviewIndex);
	
	/* 댓글 삭제 */
	public int deleteReview(int reviewIndex);	
	
}