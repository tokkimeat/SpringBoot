<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>회 원 등 록</h3>
<form method="POST" action="/join">
이름<input type="text" name="cuiName"><br>
아이디<input type="text" name="cuiId"><br>
패스워드<input type="password" name="cuiPwd"><br>
<button type ="button" onclick="join()">등록</button>
</form>
<script>
function join(){
	var xhr = new XMLHttpRequest();
	xhr.open('POST','/join');
		xhr.onreadystatechange =function(){
			if(xhr.readyState==4&& xhr.status==200){
				console.log(xhr.responseText);
				if(xhr.responseText && xhr.responseText!=null){
					alert('가입 완료!');
					location.href='/views/user/join';
				}
			}
		}
		var formData = new FormData();
		var cuiName= document.querySelector('[name=cuiName]');
		var cuiId= document.querySelector('[name=cuiId]');
		var cuiPwd = document.querySelector('[name=cuiPwd]');
		formData.append('cuiName',cuiName.value);
		formData.append('cuiId',cuiId.value);
		formData.append('cuiPwd',cuiPwd.value);
		xhr.send(formData);
}

</script>

</body>
</html>