package com.mongsil.youthbus.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongsil.youthbus.command.bimageCommand;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class webController {
	@Autowired
	private ServletContext servletContext;
	
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
	
	@RequestMapping(value = "/y_bus", method = RequestMethod.GET)
	public String y_bus(Model model){
		
		return "y_bus";
	}
	
	@RequestMapping(value = "/bimage_write", method = RequestMethod.GET)
	public String bimage_write(){

		return "bimage_write";
	}
	
	@RequestMapping(value = "/imageFTP_write", method = RequestMethod.POST)
	public String imageFTP_write(HttpServletRequest request){
		String path = "/home/hosting_users/mongsil311/tomcat/webapps/resources/bucket_image";
		String encType="UTF-8";
		int maxFileSize = 10*1024*1024;

		try {
			MultipartRequest multi = new MultipartRequest(request, path, maxFileSize, encType, new DefaultFileRenamePolicy());
			String fileName = multi.getFilesystemName("bimage");
			if(fileName != null){
				bimageCommand command = new bimageCommand();
				command.execute(fileName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:index";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("nickName");
		
		return "redirect:/";
	}
}
