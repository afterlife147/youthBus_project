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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<!-- css 占쎈쐻占쎈윥占쎈옘占쎈눇�뙼蹂��굲 -->
<link href="./resources/css/index.css" type="text/css" rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet" />
<title>청춘버스</title>
</head>
<body>
		<%@ include file="header.jsp"%>
		<input type="hidden" id="nickName" value="${nickName}" />
		<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3000">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
	   </ol>
	   <div class="carousel-inner">
	      <!--슬라이드1-->
	      <div class="item active"> 
	         <img src="/resources/img/sld1.jpg" style="width:100%" alt="First slide">
	      </div>
	      <!--슬라이드1-->
	
	      <!--슬라이드2-->
	      <div class="item"> 
	         <img src="/resources/img/sld2.jpg" style="width:100% "  data-src="" alt="Second slide">
	      </div>
	      <!--슬라이드2-->
	      
	      <!--슬라이드3-->
	      <div class="item"> 
	         <img src="/resources/img/sld3.jpg" style="width:100%" data-src="" alt="Third slide">
	      </div>
	      <!--슬라이드3-->
	   </div>
	
	</div>
		<div id="empty">
			<div id="bucketBox">
			</div>

			<div id="foot">
				<%@ include file="footer.jsp"%>
			</div>
		</div>	
    
		<div id="layerPop">
			<div id="closeBtn"></div>
			<div class="inner_bucket"></div>
			<div class="inner_reply"></div>
			<form>
				<img id="like_btn" src="/resources/img/bSmile.png">
				<input type="text" size="47" id="text_reply"/>
				<input type="button" value="작성" id="insert_reply"/>
			</form>
		</div>
</body>
</html>