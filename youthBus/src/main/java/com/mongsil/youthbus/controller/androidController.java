package com.mongsil.youthbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class androidController {
	
	@RequestMapping("/android/memberinsert")
	public String memberInsert(){
		
		return "/android/memberinsert";
	}
}
