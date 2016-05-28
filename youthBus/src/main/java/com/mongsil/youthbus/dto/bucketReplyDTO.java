package com.mongsil.youthbus.dto;

public class bucketReplyDTO {
	private int Index;
	private String userId;
	private int bucketId;
	private String name;
	private String content;
	private String writeTime;
	
	public bucketReplyDTO(){
		
	}
	public bucketReplyDTO(int index, String userId, int bucketId, String name, String content, String writeTime) {
		super();
		Index = index;
		this.userId = userId;
		this.bucketId = bucketId;
		this.name = name;
		this.content = content;
		this.writeTime = writeTime;
	}



	public int getIndex() {
		return Index;
	}
	public void setIndex(int index) {
		Index = index;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBucketId() {
		return bucketId;
	}
	public void setBucketId(int bucketId) {
		this.bucketId = bucketId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(String writeTime) {
		this.writeTime = writeTime;
	}
	
	
}
