<%@page import="com.mongsil.youthbus.dao.bucketDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	String id = request.getParameter("id");
	    String name = request.getParameter("name");
	    String formatDate = request.getParameter("formatData");
	    String bimgName = request.getParameter("bimgName");
	    String bucket_content = request.getParameter("bucket_content");
	    String bucket_like = request.getParameter("bucket_like");
	    String bucket_ripple = request.getParameter("bucket_ripple");
	    String gps_x = request.getParameter("gps_x");
	    String gps_y = request.getParameter("gps_y");
	    String tag = request.getParameter("tag");
	    
	    bucketDAO dao = bucketDAO.getInstance();
	    dao.insertBucket(id, name, formatDate, bimgName, bucket_content, bucket_like, bucket_ripple, gps_x, gps_y, tag);
    	//out.println(id + name + formatDate + bimgName + bucket_content + bucket_like + bucket_ripple + gps_x + gps_y + tag);
    %>