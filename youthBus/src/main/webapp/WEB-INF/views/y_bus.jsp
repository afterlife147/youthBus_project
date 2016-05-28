<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- script Tag -->
<script src="./resources/js/jquery-2.1.3.min.js"></script>
<script src="./resources/js/y_bus.js"></script>
<link href="./resources/css/y_bus.css" type="text/css" rel="stylesheet">
<title>청춘버스</title>
</head>
<body>
	<!-- 헤더 연결 -->
	<%@ include file="header.jsp"%>
	
	<div id="insertBox">
		<p>버킷을 입력하세요.</p>
			<input type="text" id="bucket"/>
			<input type="hidden" id="userId" value="${userId }" />
			<input type="hidden" id="nickName" value="${nickName }"/>
			<input type="button" id="nextBtn" value="다음단계" />
			
		<div id="tagDiv">
			<input type="radio" name="group" id="tag1" value="#10대"/>
			<label for="tag1">#10대</label>
			<input type="radio" name="group" id="tag2" value="#20대"/>
			<label for="tag2">#20대</label>
			<input type="radio" name="group" id="tag3" value="#30대이상"/>
			<label for="tag3">#30대이상</label>
			<input type="radio" name="group" id="tag4" value="#음식"/>
			<label for="tag4">#음식</label>
			<input type="radio" name="group" id="tag5" value="#가족"/>
			<label for="tag5">#가족</label>
			<input type="radio" name="group" id="tag6" value="#커플"/>
			<label for="tag6">#커플</label>
			<input type="radio" name="group" id="tag7" value="#생활습관"/>
			<label for="tag7">#생활습관</label>
			<input type="radio" name="group" id="tag8" value="#자기계발"/>
			<label for="tag8">#자기개발</label>
			<input type="radio" name="group" id="tag9" value="#도전"/>
			<label for="tag9">#도전</label>
			<input type="radio" name="group" id="tag10" value="#취미"/>
			<label for="tag10">#취미</label>
			<input type="radio" name="group" id="tag11" value="#다이어트"/>
			<label for="tag11">#다이어트</label>
			<input type="radio" name="group" id="tag12" value="#재테크"/>
			<label for="tag12">#재테크</label>
			<input type="radio" name="group" id="tag13" value="#일상"/>
			<label for="tag13">#일상</label>
			<input type="radio" name="group" id="tag14" value="#여행"/>
			<label for="tag14">#여행</label>
			<input type="radio" name="group" id="tag15" value="#건강"/>
			<label for="tag15">#건강</label>
		</div>
		<input type="button" id="insertBtn" value="등록하기" />
	</div>
	
	<div id="empty">
		<div id="bucketBox">
			<input type="hidden" id="userId" value="${userId }" />
		</div>
		<!-- Footer -->
		<div id="foot">	
			<%@ include file="footer.jsp"%>
		 </div>
	</div>
	
	<div id="layerPop">
		<div id="closeBtn"></div>
		<div class="inner_bucket"></div>
		<div class="inner_reply"></div>
	</div>

</body>
</html>