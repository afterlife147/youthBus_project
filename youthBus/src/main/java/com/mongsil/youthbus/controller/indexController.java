package com.mongsil.youthbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongsil.youthbus.command.command;
import com.mongsil.youthbus.command.listCommand;

@Controller
public class indexController {

	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String index(Model model){
		command command = new listCommand();
		command.execute(model);
		
		return "index";
	}
}
