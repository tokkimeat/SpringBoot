<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>ȸ �� �� ��</h3>
<form method="POST" action="/join">
�̸�<input type="text" name="cuiName"><br>
���̵�<input type="text" name="cuiId"><br>
�н�����<input type="password" name="cuiPwd"><br>
<button type ="button" onclick="join()">���</button>
</form>
<script>
function join(){
	var xhr = new XMLHttpRequest();
	xhr.open('POST','/join');
		xhr.onreadystatechange =function(){
			if(xhr.readyState==4&& xhr.status==200){
				console.log(xhr.responseText);
				if(xhr.responseText && xhr.responseText!=null){
					alert('���� �Ϸ�!');
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