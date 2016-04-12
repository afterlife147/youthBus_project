package com.mongsil.youthbus.command;

import org.springframework.ui.Model;

import com.mongsil.youthbus.dao.memberDAO;

public class listCommand implements command {

	@Override
	public void execute(Model model){
		memberDAO dao = memberDAO.getInstance();

	}

}
