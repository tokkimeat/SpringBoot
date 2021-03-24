<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="/test">
제목<input type="text" name="title"><br>
이름<input type="text" name="name"><br>
리포트 파일<input type="file" name="file"><br>
<button>리포트 전송</button>

</body>
</html>