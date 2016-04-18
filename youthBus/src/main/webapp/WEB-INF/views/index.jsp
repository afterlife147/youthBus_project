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
<script src="./resources/js/index.js"></script>

<!-- css 연결 -->
<link href="./resources/css/index.css" type="text/css" rel="stylesheet">

<title>청춘버스</title>
</head>
<body>
	<iframe>
		<!-- 헤더 -->
		<header id="header">
			<div id="logo"></div>
			<ul id="menu_ul">
				<div id="menu">
					<li class="b"><a href="#" id="t0">청춘나눔</a></li>
					<li class="b"><div class="bar">|</div></li>
					<li class="b"><a href="#" id="t1">청춘버스</a></li>
					<li class="b"><div class="bar">|</div></li>
					<li class="b"><a href="#" id="t2">청춘이야기</a></li>
					<li class="b"><div class="bar">|</div></li>
					<li class="b"><a href="#" id="t3">청춘도우미</a></li>
				</div>
			</ul>
		    <div id="outbtn"><a href="#">로그아웃</a></div>
	    </header>
	    
	    <!-- 이미지 슬라이드 -->
	    <div id="slide">
	    	<div id="s_bg1"></div>    
	    </div>
	    
		<!-- 박스 -->
		<div id="box">
			<img class="s_box" src="http://placehold.it/300x200" alt="">
			<img class="s_box" src="http://placehold.it/300x200" alt="">
			<img class="s_box" src="http://placehold.it/300x200" alt="">
			<img class="s_box" src="http://placehold.it/300x200" alt="">
			<img class="s_box" src="http://placehold.it/300x200" alt="">
			<img class="s_box" src="http://placehold.it/300x200" alt="">
			<img class="s_box" src="http://placehold.it/300x200" alt="">
			<img class="s_box" src="http://placehold.it/300x200" alt="">
		</div>
		
		<!-- 푸터 -->
		<div id="footer">
			<div id="ft_content">Copyright © 2016 Mongsil All Rights Reserved.</div>
		</div>
	</iframe>
</body>
</html>