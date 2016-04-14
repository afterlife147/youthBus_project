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
<script src="./resources/js/jquery.backstretch.min.js"></script>
<script src="./resources/js/facebook_login.js"></script>
<script src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.1.js"></script>
<script src="./resources/js/naver_login.js"></script>
<!-- css 초기화 -->

<title>청춘버스</title>
<!--background 슬라이드-->
<script>
	$(function() {
		$.backstretch([ "./resources/img/bg1.jpg", "./resources/img/bg2.jpg",
				"./resources/img/bg3.jpg" ], {
			duration : 4000,
			fade : 750
		});
	});
</script>



</head>
<body>
	<div id = "outside">
		<div id="fb" onclick="checkLoginState();" style="cursor:pointer">페이스북으로 로그인</div>
		<div id="naver_id_login" onclick="naver_login();" style="cursor:pointer"></div>
	</div>
</body>
</html>