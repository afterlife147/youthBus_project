package com.mongsil.youthbus.command;

import org.json.simple.JSONArray;

import com.mongsil.youthbus.dao.replyDAO;

public class selectBucketReplyCommand {
	
	public JSONArray execute(int bIndex){
		JSONArray jArray = new JSONArray();
		replyDAO dao = replyDAO.getInstance();
		jArray = dao.bucketReplySelect(bIndex);
		return jArray;
	}
}
