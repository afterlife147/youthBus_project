package com.mongsil.youthbus.command;

import com.mongsil.youthbus.dao.memberDAO;

public class memberCommand {

	public void execute(String id, String name, String gender) {
		memberDAO dao = memberDAO.getInstance();
		dao.memberInsert(id, name, gender);
	}

}
