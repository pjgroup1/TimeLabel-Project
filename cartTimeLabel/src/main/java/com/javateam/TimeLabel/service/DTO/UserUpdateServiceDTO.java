package com.javateam.TimeLabel.service.DTO;

public class UserUpdateServiceDTO {

    // 업데이트 관련
    private String userId;
    // 회원 이름
    private String userName;
    // 회원 비밀번호
    private String userPw;
    // 회원 전화번호
    private String userMobile;
    // 회원 이메일
    private String userEmail;
    // 회원 주소
    private String userAddress;
    // 상세 주소
    private String userAddressDetail;

    public UserUpdateServiceDTO() {
    }

    public UserUpdateServiceDTO(String userId, String userName, String userPw, String userMobile, String userEmail, String userAddress, String userAddressDetail) {
        this.userId = userId;
        this.userName = userName;
        this.userPw = userPw;
        this.userMobile = userMobile;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userAddressDetail = userAddressDetail;
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

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
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
}
