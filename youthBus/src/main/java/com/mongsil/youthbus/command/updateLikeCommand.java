package com.mongsil.youthbus.command;

import com.mongsil.youthbus.dao.bucketDAO;

public class updateLikeCommand {

	public void execute(String rIndex){
		bucketDAO dao = bucketDAO.getInstance();
		dao.updateLike(rIndex);
	}
}
