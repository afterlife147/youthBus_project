package com.mongsil.youthbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ondreamController {
	
	@RequestMapping("/ondream/insertmember")
	public String insertmember(){
		return "/ondream/insertmember";
	}
	
	@RequestMapping("/ondream/selectmember")
	public String selectmember(){
		return "/ondream/selectmember";
	}
	
	@RequestMapping("/ondream/selectcard")
	public String selectcard(){
		return "/ondream/selectcard";
	}
	
	@RequestMapping("/ondream/insertcard")
	public String insertcard(){
		return "/ondream/insertcard";
	}
	
	@RequestMapping("/ondream/insertreply")
	public String insertreply(){
		return "/ondream/insertreply";
	}
	
	@RequestMapping("/ondream/selectreply")
	public String selectreply(){
		return "/ondream/selectreply";
	}
	
}
