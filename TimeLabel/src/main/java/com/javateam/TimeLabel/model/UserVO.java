package com.javateam.TimeLabel.model;

public class UserVO {
	
	public int userIndex;
	public String userId;
	public String userPw;
	public String userName;
	public String userEmail;
	public String userContact;
	public String userZip;
	public String userAddress;
	public String userAddressDetail;
	
	public int getUserIndex() {
		return userIndex;
	}
	public void setUserIndex(int userIndex) {
		this.userIndex = userIndex;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserZip() {
		return userZip;
	}
	public void setUserZip(String userZip) {
		this.userZip = userZip;
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
	
	@Override
	public String toString() {
		return "UserVO [userIndex=" + userIndex + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userContact=" + userContact + ", userZip=" + userZip
				+ ", userAddress=" + userAddress + ", userAddressDetail=" + userAddressDetail + "]";
	}
	
	public UserVO() {
		
	}
	
	public UserVO(int userIndex, String userId, String userPw, String userName, String userEmail, String userContact,
			String userZip, String userAddress, String userAddressDetail) {
		super();
		this.userIndex = userIndex;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userZip = userZip;
		this.userAddress = userAddress;
		this.userAddressDetail = userAddressDetail;
	}
	
}
