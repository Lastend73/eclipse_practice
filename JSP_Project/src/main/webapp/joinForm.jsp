<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>myInfo</title>
    </head>

    <body>
        <h1>myinfo</h1>
        <h4>회원가입페이지 - join</h4>
        <form action="${pageContext.request.contextPath}/join" method="post">
            <input type="text" name="joinId" placeholder="아이디">
            <br>
            <input type="text" name="joinPw" placeholder="비밀번호">
            <br>
            <input type="date" name="joinBirth">
            <br>
            <input type="submit" value="회원가입">
        </form>
    </body>

    </html>