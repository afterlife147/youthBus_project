<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- meta Tag -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />

<!-- script Tag -->
<script src="./resources/js/jquery-2.1.3.min.js"></script>

<!-- css 연결 -->
<link href="./resources/css/bus.css" type="text/css" rel="stylesheet">

<title>청춘버스</title>
</head>
<body>
		<!-- 헤더 연결 -->
		<%@ include file="header.jsp"%>
	    <div id="writer">
	    	<input type="text" id="input_text"  placeholder="작성해주세요!">
	    	<input type="button" value="작성" id="input_btn" >
	    </div>
	    <!-- 푸터 연결 -->
		<%@ include file="footer.jsp"%>
</body>
</html>