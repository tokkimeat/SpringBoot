<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>FOOD REGISTRATION</h3>
	<form method="POST" action="/food-insert">
		<input type="text" id="fiName" placeholder="음식 이름"><br> <input
			type="text" id="fiPrice" placeholder="음식 가격"><br> <input
			type="text" id="fiType" placeholder="음식 유형"><br> <input
			type="text" id="fiDesc" placeholder="음식 설명"><br> <br>
		<button type="button" onclick="save()">등록</button>
	</form>

	<script>
		function save() {
			var param = {
				fiName : document.querySelector('#fiName').value,
				fiPrice : document.querySelector('#fiPrice').value,
				fiType : document.querySelector('#fiType').value,
				fiDesc : document.querySelector('#fiDesc').value,
			}

			var xhr = new XMLHttpRequest();
			xhr.open('POST', '/food-insert');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					if (xhr.responseText && xhr.responseText != null) {
						alert('등록 완료!');
						location.href = "/views/food/food-list";
					}
					

				}

			}

			xhr.setRequestHeader('content-type',
					'application/json;charset=utf-8');
			xhr.send(JSON.stringify(param));
		}
		window.onload = save;
	</script>

</body>
</html>