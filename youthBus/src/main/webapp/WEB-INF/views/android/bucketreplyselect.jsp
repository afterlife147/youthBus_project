<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.mongsil.youthbus.dao.replyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String CardIndex = request.getParameter("CardIndex");
	replyDAO dao = replyDAO.getInstance();
	JSONArray jArray = dao.bucketReplySelect(Integer.parseInt(CardIndex));
	out.println(jArray.toJSONString());
%>