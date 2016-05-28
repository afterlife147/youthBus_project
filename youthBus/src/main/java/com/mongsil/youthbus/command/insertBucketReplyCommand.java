package com.mongsil.youthbus.command;

import com.mongsil.youthbus.dao.replyDAO;

public class insertBucketReplyCommand {
	public void execute(String rIndex, String rContent, String rId, String rName, String rDate){
		
		replyDAO dao = replyDAO.getInstance();
		dao.bucketReplyInsert(rId, Integer.parseInt(rIndex), rName, rContent, rDate);
	}
}
