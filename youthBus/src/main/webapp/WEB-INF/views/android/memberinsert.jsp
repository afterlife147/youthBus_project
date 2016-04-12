<%@page import="com.mongsil.youthbus.dao.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	memberDAO dao = memberDAO.getInstance();
	dao.memberInsert(id, name, gender);
%>
