package com.mongsil.youthbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongsil.youthbus.command.memberCommand;

@Controller
public class ajaxController {
	
	@RequestMapping("/memberAjax")
	public void memberAjax(String id, String name, String gender){
		memberCommand command = new memberCommand();
		command.execute(id, name, gender);
		return;
	}
}
