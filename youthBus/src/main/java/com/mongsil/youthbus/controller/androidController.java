package com.mongsil.youthbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class androidController {
	
	@RequestMapping("/android/memberinsert")
	public String memberInsert(){
		
		return "/android/memberinsert";
	}
	
	@RequestMapping("/android/bucketinsert")
	public String bucketInsert(){
		
		return "/android/bucketinsert";
	}
	@RequestMapping("/android/bucketImg")
	public String bucketImg(){
		
		return "/android/bucketImg";
	}
	@RequestMapping("/android/bucketselect")
	public String bucketSelect(){
		
		return "/android/bucketselect";
	}
	@RequestMapping("/android/bucketimgcount")
	public String bucketImgCount(){
		
		return "/android/bucketimgcount";
	}
	@RequestMapping("/android/mybucketselect")
	public String mybucketselect(){
		
		return "/android/mybucketselect";
	}
	@RequestMapping("/android/bucketreplyinsert")
	public String bucketreplyinsert(){
		
		return "/android/bucketreplyinsert";
	}
	@RequestMapping("/android/bucketreplyselect")
	public String bucketreplyselect(){
		
		return "/android/bucketreplyselect";
	}
}
