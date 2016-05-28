package com.mongsil.ondream.dto;

public class replyDTO {
	private int rIndex;
	private int rCardIndex;
	private String rUserId;
	private String rContent;
	private String rTime;
	
	public replyDTO() {
		super();
	}

	public replyDTO(int rIndex, int rCardIndex, String rUserId, String rContent, String rTime) {
		super();
		this.rIndex = rIndex;
		this.rCardIndex = rCardIndex;
		this.rUserId = rUserId;
		this.rContent = rContent;
		this.rTime = rTime;
	}

	public int getrIndex() {
		return rIndex;
	}

	public void setrIndex(int rIndex) {
		this.rIndex = rIndex;
	}

	public int getrCardIndex() {
		return rCardIndex;
	}

	public void setrCardIndex(int rCardIndex) {
		this.rCardIndex = rCardIndex;
	}

	public String getrUserId() {
		return rUserId;
	}

	public void setrUserId(String rUserId) {
		this.rUserId = rUserId;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getrTime() {
		return rTime;
	}

	public void setrTime(String rTime) {
		this.rTime = rTime;
	}
	
	
}
