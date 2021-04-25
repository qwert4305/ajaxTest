<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- controller 와 연결됐는지 확인 -->
ajaxTest입니다.

<!-- DB와 연결해서 결과값(resultType) list 타입으로 가져오는지 확인 , param 없이  -->
<c:forEach var="li" items="${list}">
${li.id }<br>
${li.name }<br>
</c:forEach>

<!-- DB와 연결해서 입력값(parameterType) 넣었을 때 결과값(resultType) list 타입으로 가져오는지 확인  -->
<form action="/ajaxTest.do">
<input type="text" name="id" id="id">
<input type="text" name="name" id="name">
<input type="submit">
</form>


</body>
</html>