package com.mongsil.youthbus.controller;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mongsil.youthbus.command.insertBucketCommand;
import com.mongsil.youthbus.command.insertBucketReplyCommand;
import com.mongsil.youthbus.command.memberCommand;
import com.mongsil.youthbus.command.selectBucketCommand;
import com.mongsil.youthbus.command.selectBucketReplyCommand;
import com.mongsil.youthbus.command.selectmyBucketCommand;
import com.mongsil.youthbus.command.updateLikeCommand;
import com.mongsil.youthbus.dto.memberDTO;

@Controller
@SessionAttributes({"nickName", "userId"})
public class ajaxController {
	
	@RequestMapping("/memberAjax")
	public void memberAjax(String id, String name, String gender, Model model){
		memberCommand command = new memberCommand();
		memberDTO dto = command.execute(id, name, gender);
		model.addAttribute("userId", dto.getUserid());
		model.addAttribute("nickName", dto.getNickname());
		
		return;
	}
	@RequestMapping("/insertBucket")
	public void insertBucket(String id, String name, String bContent, String Tag){
		insertBucketCommand command = new insertBucketCommand();
		command.execute(id, name, bContent, Tag);
		
		return;
	}
	
	@RequestMapping("/selectBucket")
	@ResponseBody
	public JSONArray selectBucket(int bIndex){
		JSONArray jArray = new JSONArray();
		selectBucketCommand command = new selectBucketCommand();
		jArray = command.execute(bIndex);
		return jArray;
	}
	@RequestMapping("/selectmyBucket")
	@ResponseBody
	public JSONArray selectmyBucket(int bIndex, String id){
		JSONArray jArray = new JSONArray();
		selectmyBucketCommand command = new selectmyBucketCommand();
		jArray = command.execute(bIndex, id);
		return jArray;
	}
	@RequestMapping("/selectBucketReply")
	@ResponseBody	
	public JSONArray selectBucketReply(int bIndex){
		JSONArray jArray = new JSONArray();
		selectBucketReplyCommand command = new selectBucketReplyCommand();
		jArray = command.execute(bIndex);
		return jArray;
	}
	
	@RequestMapping("/insertBucketReply")
	public void insertBucketReply(String rIndex, String rContent, String rId, String rName, String rDate){
		insertBucketReplyCommand command = new insertBucketReplyCommand();
		command.execute(rIndex, rContent, rId, rName, rDate);
		
		return;
	}
	@RequestMapping("/updateLike")
	public void updateLike(String rIndex){
		updateLikeCommand command = new updateLikeCommand();
		command.execute(rIndex);
		
		return;
	}
}
