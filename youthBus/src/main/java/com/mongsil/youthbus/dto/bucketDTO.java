package com.mongsil.youthbus.dto;

public class bucketDTO {
	private String bIndex;
	private String bId;
	private String bName;
	private String bDate;
	private String bImage;
	private String bContent;
	private String bLike;
	private String bReply;
	private String bGPS_X;
	private String bGPS_Y;
	private String bTag;
	
	public bucketDTO(){
		
	}
	public bucketDTO(String bId, String bName, String bDate, String bImage, String bContent, String bLike,
			String bReply, String bGPS_X, String bGPS_Y, String bTag) {
		this.bId = bId;
		this.bName = bName;
		this.bDate = bDate;
		this.bImage = bImage;
		this.bContent = bContent;
		this.bLike = bLike;
		this.bReply = bReply;
		this.bGPS_X = bGPS_X;
		this.bGPS_Y = bGPS_Y;
		this.bTag = bTag;
	}
	
	public String getbIndex() {
		return bIndex;
	}

	public void setbIndex(String bIndex) {
		this.bIndex = bIndex;
	}

	public String getbId() {
		return bId;
	}
	public void setbId(String bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	public String getbImage() {
		return bImage;
	}
	public void setbImage(String bImage) {
		this.bImage = bImage;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbLike() {
		return bLike;
	}
	public void setbLike(String bLike) {
		this.bLike = bLike;
	}
	public String getbReply() {
		return bReply;
	}
	public void setbReply(String bReply) {
		this.bReply = bReply;
	}
	public String getbGPS_X() {
		return bGPS_X;
	}
	public void setbGPS_X(String bGPS_X) {
		this.bGPS_X = bGPS_X;
	}
	public String getbGPS_Y() {
		return bGPS_Y;
	}
	public void setbGPS_Y(String bGPS_Y) {
		this.bGPS_Y = bGPS_Y;
	}
	public String getTag() {
		return bTag;
	}
	public void setTag(String bTag) {
		this.bTag = bTag;
	}
	
	
}
