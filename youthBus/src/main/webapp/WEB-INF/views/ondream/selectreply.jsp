<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.mongsil.ondream.dao.replyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	String cardIndex = request.getParameter("cardIndex");
    	replyDAO dao = replyDAO.getInstance();
    	JSONArray jArray = dao.selectReply(Integer.parseInt(cardIndex));
    	out.println(jArray.toJSONString());
    %>