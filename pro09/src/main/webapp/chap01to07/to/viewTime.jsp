<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현재 시간</title>
</head>
<body>
<% Calendar cal = (Calendar)request.getAttribute("time"); %>

현재 시간은 <%= cal.get(Calendar.HOUR) %>시 <%=cal.get(Calendar.MINUTE) %>분 <%=cal.get(Calendar.SECOND) %>초 입니다.
</body>
</html>