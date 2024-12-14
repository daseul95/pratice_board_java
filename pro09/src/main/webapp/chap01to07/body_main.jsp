<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INFO</title>
</head>
<body>
 include 전 name 파라미터 값 : <%= request.getParameter("name") %>
 
<hr>
 
 <jsp:include page= "/chap01to07/body_sub.jsp" flush="false">
 <jsp:param name="name" value="최범균"/>
 </jsp:include>
 
 <hr/>
 
 include 후 name 파라미터 값 : <%= request.getParameter("name") %>
</body>
</html>