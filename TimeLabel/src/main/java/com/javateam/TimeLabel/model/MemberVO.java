package com.javateam.TimeLabel.model;
// 테스트용 클래스
public class MemberVO {
	
	private String ID;
	private String PW;
	private String NAME;
	
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	public MemberVO() {
	}
	public MemberVO(String ID, String PW, String NAME) {
		this.ID = ID;
		this.PW = PW;
		this.NAME = NAME;
	}
	public String getId() {
		return ID;
	}
	public void setId(String ID) {
		this.ID = ID;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String PW) {
		this.PW = PW;
	}
	@Override
	public String toString() {
		return "MemberVO [ID=" + ID + ", PW=" + PW + ", NAME=" + NAME + "]";
	}
	
}
