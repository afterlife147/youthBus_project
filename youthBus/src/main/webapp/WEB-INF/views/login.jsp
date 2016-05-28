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
<script src="./resources/js/naverLogin_implicit-1.0.1.js"></script>
<script src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.1.js"></script>
<script src="./resources/js/login.js"></script>

<!-- css 연결 -->
<link href="./resources/css/login.css" type="text/css" rel="stylesheet">

<title>청춘버스</title>

</head>
<body>
	<header id="header">
		<div id="l_logo"></div>
	</header>
	<div id = "outside">
		<div id="fb" onclick="checkLoginState();" style="cursor:pointer"></div>
		<div id="naver_id_login" style="cursor:pointer"></div>
	</div>
<script>
	naver = new naver_id_login("HuF4g6zbRdU8Ap3FKbw2", "http://mongsil311.cafe24.com/naver_login");
	naver.setButton('green', 4, 50);
	naver.setPopup('true');
	naver.init_naver_id_login();
</script>

</body>
</html>