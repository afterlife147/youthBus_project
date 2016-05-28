<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.mongsil.ondream.dao.cardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String cIndex = request.getParameter("cIndex");
    
    	cardDAO dao = cardDAO.getInstance();
    	JSONArray jArray = dao.selectCard(Integer.parseInt(cIndex));
    	out.println(jArray.toJSONString());
    %>
