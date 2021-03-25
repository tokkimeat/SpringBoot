<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>로그인</h3>
customerInfo : ${customerInfo}<br>
<input type= "text" id ="cuiId" name ="cuiId" placeholder="아이디"><br>
<input type= "text" id ="cuiPwd" name ="cuiPwd" placeholder="비밀번호"><br>
<br><button onclick="login()">로그인</button>
<script>
window.onload = function(){
	document.querySelector('#cuiId').focus();
}
function login(){
	/*
	var Id = document.querySelector('#cuiId');
	if(Id.value.trim().length<3){
		alert('아이디 혹은 비밀번호를 다시 확인하세요.');
		Id.focus();
		return
	}
	var Pwd = document.querySelector('#cuiPwd');
	if(Pwd.value.trim().length<3){
		alert('아이디 혹은 비밀번호를 다시 확인하세요.');
		Id.focus();
		return
	}*/
	var param ={
		 cuiId : document.querySelector('#cuiId').value,
		cuiPwd : document.querySelector('#cuiPwd').value
	}
	/*var formData = new FormData();
	var cuiId = document.querySelector('#cuiId');
	var cuiPwd = document.querySelector('#cuiPwd');
	formData.append('cuiId',cuiId.value);
	formData.append('cuiPwd',cuiPwd.value);
	*/
	
	var xhr = new XMLHttpRequest();
	xhr.open('POST','/login');
	xhr.onreadystatechange= function(){
		if(xhr.readyState==4 && xhr.status==200){
			if(xhr.responseText){
				var res = JSON.parse(xhr.responseText);
				alert(res.cuiName+'님 로그인 성공');
				location.href='/';
			return;
			}
			alert('아이디나 비밀번호를 확인해주세요.');
		}
	}
	xhr.setRequestHeader('content-type', 'application/json;charset=utf-8');
	xhr.send(JSON.stringify(param));
}
		
		

</script>

</body>
</html>