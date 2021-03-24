<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="/file-info">
<input type="text" name="fiiTitle"><br>
<textarea name ="fiiContent"></textarea><br>
<input type="file" name="fiiFile" id ="fiFile"><br>
<button type ="button" onclick="insert()">전송</button>
<script>
function insert(){
	var xhr = new XMLHttpRequest();
	xhr.open('POST','/file-info');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			if(xhr.responseText&& xhr.responseText!=null){
				alert('등록 완료');
				location.href='/views/file-info-list';
			}
		}
	}
	var formData = new FormData();
	var fiiTitle = document.querySelector('[name=fiiTitle]');
	var fiiContent = document.querySelector('[name=fiiContent]');
	var fiiFile = document.querySelector('[name=fiiFile]');
	formData.append('fiiTitle',fiiTitle.value);
	formData.append('fiiContent',fiiContent.value);
	formData.append('fiiFile',fiiFile.files[0]);
	xhr.send(formData);
}
</script>
</form>
</body>
</html>