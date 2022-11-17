package com.javateam.TimeLabel.service.DTO;

public class UserSearchDTO {
	
	private String userId;
	// 회원 이름
	private String userName;
	// 회원 전화번호
	private String userMobile;
	// 회원 이메일
	private String userEmail;
	// 우편 번호
	private String zip;
	// 회원 주소
	private String userAddress;
	// 상세 주소
	private String userAddressDetail;

	@Override
	public String toString() {
		return "UserSearch{" +
				"userId='" + userId + '\'' +
				", userName='" + userName + '\'' +
				", userMobile='" + userMobile + '\'' +
				", userEmail='" + userEmail + '\'' +
				", zip='" + zip + '\'' +
				", userAddress='" + userAddress + '\'' +
				", userAddressDetail='" + userAddressDetail + '\'' +
				'}';
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserAddressDetail() {
		return userAddressDetail;
	}

	public void setUserAddressDetail(String userAddressDetail) {
		this.userAddressDetail = userAddressDetail;
	}


	public UserSearchDTO() {
	}

	public UserSearchDTO(String userId, String userName, String userMobile, String userEmail, String zip, String userAddress, String userAddressDetail) {
		this.userId = userId;
		this.userName = userName;
		this.userMobile = userMobile;
		this.userEmail = userEmail;
		this.zip = zip;
		this.userAddress = userAddress;
		this.userAddressDetail = userAddressDetail;
	}


}
