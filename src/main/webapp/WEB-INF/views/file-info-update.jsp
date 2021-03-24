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
	<textarea name="fiiContent"></textarea><br>
	<input type="file" name="fiiFile" id="fiiFile" onchange ="changeImg(this)"><br>
	<div id="fiiFilePath"></div>
	<button type="button" onclick="update()">수정</button>
</form>
<script>
function changeImg(obj){
	if (obj.files && obj.files[0]){
		var reader = new FileReader();
		reader.onload = function(e){
		
		document.querySelector('#preview').src = e.target.result;
		
	}
	reader.readAsDataURL(obj.files[0]);
	}
}
var fiiNum = '${param.fiiNum}';
var objs = document.querySelectorAll('input[name],textarea[name]');
function update(){
 	var xhr = new XMLHttpRequest();
	xhr.open('POST','/file-info/update');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			if(xhr.responseText && xhr.responseText!=null){
				alert('등록 완료');
				location.href='/views/file-info-list';
			}
		}
	}
	var formData = new FormData()
	var fiiTitle = document.querySelector('[name=fiiTitle]');
	var fiiContent = document.querySelector('[name=fiiContent]');
	var fiiFile = document.querySelector('[name=fiiFile]');
	formData.append('fiiNum',fiiNum);
	formData.append('fiiTitle',fiiTitle.value);
	formData.append('fiiContent',fiiContent.value);
	formData.append('fiiFile',fiiFile.files[0]);
	xhr.send(formData);
}
function getFileInfo(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/file-info?fiiNum='+fiiNum);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var res = JSON.parse(xhr.responseText);
			for(var obj of objs){
				obj.value = res[obj.name];
			}
			document.querySelector('#fiiFilePath').innerHTML = '<img width="200" id="preview" src="/resources/' + res.fiiFilePath + '">';
		}
	}
	xhr.send();
}
window.onload = getFileInfo;
</script>
</body>
</html>