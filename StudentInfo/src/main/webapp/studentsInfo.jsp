<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 조회 시스템</title>
</head>
<body>
	<!-- 새로고침 전송방식 get방식, 새로고침을 누르면 href에서 지정한 경로로 이동함 -->
	<H1>학생 정보</H1>
	[ <a href="/StudentInfo/StudentController">새로고침</a>]  
	<hr>
	<table border="1">
		<tr><th>id</th><th>이름</th>
		<th>대학</th><th>생일</th><th>이메일</th></tr>
		<c:forEach items="${students}" var ="s">
			<tr>
				<td>${s.id}</td>
				<td>${s.username}</td>
				<td>${s.univ}</td>
				<td>${s.birth}</td>
				<td>${s.email}</td>
			</tr>		
		</c:forEach>
	</table>
	
	<hr>
	
	<h2>학생 추가</h2>
	<hr>
	<!-- 학생추가 post방식 -->
	<form method="post" action="/StudentInfo/StudentController?action=insert">
		<label>이름</label>
		<input type="text" name="username"><br>
		<label>대학</label>
		<input type="text" name="univ"><br>
		<label>생일</label>
		<input type="text" name="birth"><br>
		<label>이메일</label>
		<input type="text" name="email"><br>
		<button type="submit">등록</button>
	</form>
	
</body>
</html>    