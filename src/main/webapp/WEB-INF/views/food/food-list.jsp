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
	<input type="text" id="fiName" placeholder="이름"><br>
	<input type="text" id="fiType" placeholder="유형">
	<button onclick="search()">검색</button>
	<table border="1">
		<tr>
				<td>번호</td>
				<td>이름</td>
				<td>가격</td>
				<td>유형</td>
				<td>음식설명</td>
			</tr>
		
		<tbody id="tBody">
		</tbody>
		
	</table>
	<button onclick="location.href='/views/food/food-insert'">등록</button>
	<script>
		function search() {
			var xhr = new XMLHttpRequest();
			var param ='?';
			if(document.querySelector('#fiName').value.trim()){
				param+= 'fiName='+'%'+ document.querySelector('#fiName').value.trim()+'%'+'&';
			}
			if(document.querySelector('#fiType').value.trim()){
				param+= 'fiType='+ document.querySelector('#fiType').value.trim()+'&';
			}
			xhr.open('GET', '/food-infos'+param);
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