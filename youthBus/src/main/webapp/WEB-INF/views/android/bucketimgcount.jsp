<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.mongsil.youthbus.dao.bucketDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<%
	bucketDAO dao = bucketDAO.getInstance();
	JSONObject obj = dao.selectBucketImgCount();
	out.println(obj);
%>