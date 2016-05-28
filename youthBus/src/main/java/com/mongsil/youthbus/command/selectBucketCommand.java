package com.mongsil.youthbus.command;

import org.json.simple.JSONArray;

import com.mongsil.youthbus.dao.bucketDAO;

public class selectBucketCommand {
	public JSONArray execute(int bIndex){
		JSONArray jArray = new JSONArray();
		bucketDAO dao = bucketDAO.getInstance();
		jArray = dao.selectBucketWeb(bIndex);
		return jArray;
	}
}
