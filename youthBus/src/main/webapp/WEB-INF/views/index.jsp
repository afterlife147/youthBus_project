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
<!--페이스북 로그인-->
<script>
//페이스북 SDK 초기화
	window.fbAsyncInit = function() {
	    FB.init({appId: '856055527837167', status: true, cookie: true, xfbml: true});
	};
	(function(d){
	   var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
	   if (d.getElementById(id)) {return;}
	   js = d.createElement('script'); js.id = id; js.async = true;
	   js.src = "//connect.facebook.net/ko_KR/all.js";
	   ref.parentNode.insertBefore(js, ref);
	 }(document));


	function facebooklogin() {  
		//페이스북 로그인 버튼을 눌렀을 때의 루틴.  
			FB.login(function(response) {  
				var fbname;  
				var accessToken = response.authResponse.accessToken;  
				FB.api('/me', function(user) {  
					fbname = user.name;  
					//response.authResponse.userID  
					$.post("./fbloginprocess.jsp", { "userid": user.id, "username": fbname, "fbaccesstoken":accessToken},  
					function (responsephp) {  
						//댓글을 처리한 다음 해당 웹페이지를 갱신 시키기 위해 호출.  
						location.replace('./main.jsp');  
					});      
				});   
			}, {scope: 'public_profile,email'});  
	}  

</script>
	<div id = "outside">
		<div id="fb" onclick="facebooklogin()" style="cursor: pointer;">페이스북으로 로그인</div>
		<div id="naver_id_login"></div>
	</div>
</body>
</html>