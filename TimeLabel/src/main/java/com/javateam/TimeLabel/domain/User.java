package com.javateam.TimeLabel.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

public class User {
	private int no;
	private String id;
	private String name;
	private String pw;
	private Date date;
	private String email;
	private String birth;
	private String mobile;
	private String address;
	private String detailAddress;

	public User() {}
	public User(String id, String name, String pw, Date date, String email, String birth, String mobile, String address, String detailAddress) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.date = date;
		this.email = email;
		this.birth = birth;
		this.mobile = mobile;
		this.address = address;
		this.detailAddress = detailAddress;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
}