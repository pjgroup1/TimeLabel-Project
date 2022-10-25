package com.javateam.TimeLabel.dto;

import java.sql.Date;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
// 회원 DTO
public class User {
	// 회원 번호 (자동 증가)
	private long user_no;
	// 회원 아이디
	private String user_id;
	// 회원 이름
	private String user_name;
	// 회원 비밀번호
	private String user_pw;
	// 회원 전화번호
	private String user_mobile;
	// 회원 이메일
	private String user_email;
	// 회원 생년 월일
	private Date user_birth;
	// 회원 주소
	private String address;
	// 상세 주소
	private String address_detail;
	// 가입일
	private Date user_date;

	
	
}