<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% //스크립 플릿 %>
	<% String str = "JSP 페이지 입니다"; %>
	<h1><%=str %> </h1>
	
	<% for (int i = 0 ; i <5; i++){%>
		<h1><%=i%></h1>
		<%} %>
	}
	
</body>
</html>