package com.javateam.TimeLabel.service;

import java.sql.Date;

import lombok.Data;

@Data
public class UserSearch {
	
	private String user_id;
	// 회원 이름
	private String user_name;
	// 회원 전화번호
	private String user_mobile;
	// 회원 이메일
	private String user_email;
	// 회원 주소
	private String address;
	// 상세 주소
	private String address_detail;
}
