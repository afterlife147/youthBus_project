package com.mongsil.youthbus.command;

import org.json.simple.JSONArray;

import com.mongsil.youthbus.dao.bucketDAO;

public class selectmyBucketCommand {
	public JSONArray execute(int bIndex, String id){
		JSONArray jArray = new JSONArray();
		bucketDAO dao = bucketDAO.getInstance();
		jArray = dao.selectMyBucket(id, bIndex);
		return jArray;
	}
}
