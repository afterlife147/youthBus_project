<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>이미지 등록</title>
</head>
<body>
	<form action="imageFTP_write" method="post" enctype="multipart/form-data">
		<input type="file" name="bimage" /> <br>
		<input type="submit" value="등록">
	</form>
</body>
</html>