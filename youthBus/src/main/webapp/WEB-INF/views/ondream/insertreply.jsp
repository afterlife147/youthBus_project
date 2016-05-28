<%@page import="com.mongsil.ondream.dao.replyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	String rCardIndex = request.getParameter("rCardIndex");
    	String rUserId = request.getParameter("rUserId");
    	String rContent = request.getParameter("rContent");
    	String rTime = request.getParameter("rTime");
    	
    	replyDAO dao = replyDAO.getInstance();
    	dao.insertReply(rCardIndex, rUserId, rContent, rTime);
    %>