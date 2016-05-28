<%@page import="com.mongsil.ondream.dao.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String userid = request.getParameter("userid");
    	String userpwd = request.getParameter("userpwd");
    	String userage = request.getParameter("userage");
    	String usergender = request.getParameter("usergender");
    	
    	memberDAO dao = memberDAO.getInstance();
    	int result = dao.memberInsert(userid, userpwd, userage, usergender);
    	out.print(result);
    %>
