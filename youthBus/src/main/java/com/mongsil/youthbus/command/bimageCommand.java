package com.mongsil.youthbus.command;

import com.mongsil.youthbus.dao.bucketDAO;

public class bimageCommand {
	public void execute(String fileName){
		bucketDAO dao = bucketDAO.getInstance();
		dao.insertBucketImage(fileName);
	}
}
