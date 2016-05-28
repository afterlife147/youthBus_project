package com.mongsil.youthbus.command;

import org.springframework.web.servlet.ModelAndView;

import com.mongsil.youthbus.dao.memberDAO;
import com.mongsil.youthbus.dto.memberDTO;

public class memberCommand {

	public memberDTO execute(String id, String name, String gender) {
		memberDAO dao = memberDAO.getInstance();
		memberDTO dto = dao.memberInsert(id, name, gender);
		
		return dto;
	}

}
