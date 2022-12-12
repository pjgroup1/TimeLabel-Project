package com.javateam.TimeLabel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javateam.TimeLabel.model.ReviewDTO;
import com.javateam.TimeLabel.service.ReviewService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	@Qualifier("reviewService")
	private ReviewService reviewService;

	/* 댓글 등록 */
	@GetMapping("/enroll")
	public String enrollReviewGET(ReviewDTO dto, Model model) {
		model.addAttribute("item", dto);
		return "user/reviewEnroll";
	}

	@ResponseBody
	@PostMapping("/enroll")
	public String enrollReviewPOST(int productIndex, int userIndex, String reviewContent) {
		ReviewDTO dto = new ReviewDTO();
		dto.setProductIndex(productIndex);
		dto.setUserIndex(userIndex);
		dto.setReviewContent(reviewContent);
		int result = reviewService.enrollReview(dto);
		log.info("enroll 진입");
		return String.valueOf(result);
	}

	/* 댓글 체크 */
	/* userIndex, productIndex 파라미터 */
	/* 존재 : 1 / 존재x : 0 */
	@PostMapping("/check")
	public String reviewCheckPOST(ReviewDTO dto) {
		return reviewService.checkReview(dto);
	}

	/*
	 * 댓글 페이징
	 * 
	 * @GetMapping(value="/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 * public ReviewPageDTO reviewListPOST(Criteria cri) { return
	 * reviewService.reviewList(); }
	 */
	 
	/* 댓글 수정 */
	@PostMapping("/update")
	public void reviewModifyPOST(ReviewDTO dto) {
		reviewService.updateReview(dto);
	}

	/* 댓글 삭제 */
	@PostMapping("/delete")
	public void reviewDeletePOST(ReviewDTO dto) {
		reviewService.deleteReview(dto);
	}

}