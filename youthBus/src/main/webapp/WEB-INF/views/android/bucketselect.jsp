<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.mongsil.youthbus.dao.bucketDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	String bIndex = request.getParameter("index");
    	bucketDAO dao = bucketDAO.getInstance();
    	JSONArray jArray = dao.selectBucketApp(Integer.parseInt(bIndex));
    	out.println(jArray.toJSONString());
    %>