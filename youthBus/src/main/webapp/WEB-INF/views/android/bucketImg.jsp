<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.mongsil.youthbus.dao.bucketDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String imgInx = request.getParameter("index");
	bucketDAO dao = bucketDAO.getInstance();
	JSONObject obj = dao.selectBucketImage(imgInx);
%>
<%
	out.println(obj.toJSONString());
%>