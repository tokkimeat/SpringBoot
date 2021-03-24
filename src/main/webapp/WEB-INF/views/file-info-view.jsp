<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>번호</th>
<td data-col = "fiiNum"></td>
</tr>
<tr>
<th>제목</th>
<td data-col = "fiiTitle"></td>
</tr>
<tr>
<th>내용</th>
<td data-col = "fiiContent" data-type="enter"></td>
</tr>
<tr>
<th>이미지</th>
<td data-col = "fiiFilePath" data-type="img"></td>
</tr>
<tr>
<th colspan="2"><button onclick="location.href='/views/file-info-update?fiiNum=${param.fiiNum}'">수정</button><button onclick="remove()">삭제</button></th>

</tr>

</table>
<button onclick="location.href='/views/file-info-insert'">등록</button>

<script>
var url = '/file-info?fiiNum=${param.fiiNum}';
function remove(){
	var xhr = new XMLHttpRequest();
	xhr.open('DELETE',url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			console.log(xhr.responseText);
			if(xhr.responseTest=='1'){
				alert('삭제 완료');
				location.href="/views/file-info-list";
			}else{
				alert('삭제 실패');
			}
		}
	}
	xhr.send();
}
window.onload= function(){	
	var xhr = new XMLHttpRequest();
	xhr.open('GET',url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			console.log(xhr.responseText);
			var res= JSON.parse(xhr.responseText);
			var tds = document.querySelectorAll('td[data-col]');
			for(var td of tds){
				var col = td.getAttribute('data-col');
				var type =td.getAttribute('data-type');
				var data = res[col];
				if(type==='img'){
					data = '<img src="/resources/'+ res[col] + '"width="250">'
				}else if (type==='enter'){
					data = data.split('\n').join('<br>');
				}
				td.innerHTML = data;
			}
		}
	}
	
	xhr.send();
}
	

</script>
</body>
</html>