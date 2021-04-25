<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function search() {
		var id = $("#id").val();
		var name = $("#name").val();
		
		$.ajax({
			url : "/ajax",
			type : "post",
			dataType : "json",
			data : {
			// dto명 : 값 (컨트롤러에서 dto 타입으로 받을 때 )
				id : id, // a는 controller에서 파라미터가 받는 변수명과 매핑 , id는 input의 id와 매핑 
				name : name
			},
			success : function(data) {
				alert(data.result[0].id); // ajax 는 controller에서 addobject로 싣는 이름 
				$("#result1").text(data.result[0].id);
				$("#result2").text(data.result[0].name);
				$("#result3").text(data.result[1].id);
				$("#result4").text(data.result[1].name);
				
			}

		});
	}
</script>
</head>
<body>
   
	<input type="text" id="id" name="id" placeholder="id">
	<input type="text" id="name" name="name" placeholder="name">
	<input type="button" onclick="search()" value="검색">
	<div id="result1"></div>
	<div id="result2"></div>
	<div id="result3"></div>
	<div id="result4"></div>



</body>
</html>