package com.mongsil.youthbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongsil.youthbus.command.memberCommand;

@Controller
public class ajaxController {
	@RequestMapping("/memberAjax")
	@ResponseBody
	public void memberAjax(String id, String name, String gender){
		memberCommand command = new memberCommand();
		command.execute(id, name, gender);
		
		return;
	}
}
