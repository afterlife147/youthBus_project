<%@page import="com.mongsil.ondream.dao.cardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	String cuserId = request.getParameter("cuserId");
    	String cContent = request.getParameter("cContent");
    	String cImage = request.getParameter("cImage");
    	String cTime = request.getParameter("cTime");
    	cardDAO dao = cardDAO.getInstance();
    	dao.insertCard(cuserId, cContent, cImage, cTime);
    %>