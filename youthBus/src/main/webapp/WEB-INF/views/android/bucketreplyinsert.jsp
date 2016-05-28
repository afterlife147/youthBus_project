<%@page import="com.mongsil.youthbus.dao.replyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	String bucketId = request.getParameter("bucketId");
	String rName = request.getParameter("rName");
	String bucketReply = request.getParameter("bucketReply");
	String writeTime = request.getParameter("writeTime");
	
	replyDAO dao = replyDAO.getInstance();
	dao.bucketReplyInsert(userId, Integer.parseInt(bucketId), rName, bucketReply, writeTime);
%>