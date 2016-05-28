<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.mongsil.youthbus.dao.bucketDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	String bId = request.getParameter("bId");
    	String bIndex = request.getParameter("bIndex");
    	bucketDAO dao = bucketDAO.getInstance();
    	JSONArray jArray = dao.selectMyBucket(bId, Integer.parseInt(bIndex));
    	out.println(jArray.toJSONString());
    %>