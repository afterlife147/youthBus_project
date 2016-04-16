package com.mongsil.youthbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class webController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model) {

		return "login";
	}
	
	@RequestMapping(value = "/naver_login", method = RequestMethod.GET)
	public String naver_login(){
		
		return "naver_login";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model){

		return "index";
	}
	
}
