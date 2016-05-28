<%@page import="com.mongsil.ondream.dao.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String userid = request.getParameter("userid");
    	String userpwd = request.getParameter("userpwd");
    	memberDAO dao = memberDAO.getInstance();
    	
    	int result = dao.memberselect(userid, userpwd);
    	out.print(result);
    
    %>
