<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 디렉티브</title>
</head>
<body>

<% int number= 10; %>

<%@ include file="/chap01to07/includee.jspf" %>

공통변수 DATAFOLER = "<%= dataFolder %>"

</body>
</html>