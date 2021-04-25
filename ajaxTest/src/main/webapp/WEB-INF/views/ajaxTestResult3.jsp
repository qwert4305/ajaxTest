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
		//var name = $("#pw").val();
		
		$.ajax({
			url : "/ajax",
			type : "post",
			dataType : "json",
			data : {
				a : id // a는 controller에서 파라미터가 받는 변수명과 매핑 , id는 input의 id와 매핑 
				//b : name
			},
			success : function(data) {
				alert(data.ajax[0]); // ajax 는 controller에서 addobject로 싣는 이름 
				$("#result").text(data.ajax[0]);
			}

		});
	}
</script>
</head>
<body>
   
	<input type="text" id="id" name="id">
	<!-- <input type="text" id="name" name="name"> -->
	<input type="button" onclick="search()" value="검색">
	<div id="result"></div>



</body>
</html>