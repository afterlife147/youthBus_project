package com.mongsil.youthbus.command;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;

import com.mongsil.youthbus.dao.bucketDAO;

public class insertBucketCommand {
	
	public void execute(String bId, String bName, String bContent, String bTag){
		String bLike = "0";
		String bReply = "0";
		String bGPS_X = "0";
		String bGPS_Y = "0";
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String bDate = format.format(date);
		
		bucketDAO dao = bucketDAO.getInstance();
		
		JSONObject obj = dao.selectBucketImgCount();
		String imgInx = (String) obj.get("imgcount");
		int imgCount = (int) ((Math.random() * Integer.parseInt(imgInx)) + 1);
		JSONObject imgObj = dao.selectBucketImage(Integer.toString(imgCount));
		String bImage = (String) imgObj.get("bucket_img");
		
		dao.insertBucket(bId, bName, bDate, bImage, bContent, bLike, bReply, bGPS_X, bGPS_Y, bTag);
	}
}
