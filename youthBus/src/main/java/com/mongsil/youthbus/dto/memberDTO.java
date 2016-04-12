package com.mongsil.youthbus.dto;

public class memberDTO {
	private int index;
	private String userid;
	private String nickname;
	private String gender;
	
	public memberDTO(int index, String userid, String nickname, String gender){
		this.index = index;
		this.userid = userid;
		this.nickname = nickname;
		this.gender = gender;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
