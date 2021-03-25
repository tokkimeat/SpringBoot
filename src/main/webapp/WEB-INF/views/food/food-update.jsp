<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>FOOD LIST</h3>
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>가격</td>
				<td>유형</td>
				<td>음식설명</td>
			</tr>
		</thead>
		<tbody id="tBody"></tbody>
	</table>
	<script>
		function search() {
			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/food-infos');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					var res = JSON.parse(xhr.responseText);
					var html='';
					for(var fi of res){
						html+='<tr>';
						html+='<td>'+fi.fiNum+'</td>';
						html+='<td onclick="location.href=\'/views/food/food-view?fiNum='+fi.fiNum+'\'" style="cursor:pointer">'+fi.fiName+'</td>'
						html+='<td>'+fi.fiPrice+'</td>'
						html+='<td>'+fi.fiType+'</td>'
						html+='<td>'+fi.fiDesc+'</td>'
						html+='</tr>';											
					}
					document.querySelector('#tBody').innerHTML = html;
					
				}

			}
			xhr.send();
		}
		window.onload = search;
	</script>

</body>
</html>