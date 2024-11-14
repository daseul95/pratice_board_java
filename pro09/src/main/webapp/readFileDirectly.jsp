<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>절대 경로 사용해서 자원 읽기</title>
</head>
<body>

<%
	char[] buff = new char[128];
	int len=-1;
	
	String filePath="C:\\apache-tomcat-9.0.46\\apache-tomcat-9.0.46\\webapps"+"\\notice.txt";
	try(InputStreamReader fr = new InputStreamReader(new FileInputStream(filePath), "UTF-8")){
		while((len=fr.read(buff))!=-1){
			out.print(new String(buff, 0, len));
		}
	}catch(IOException ex){
		out.print("익셉션 발생: "+ex.getMessage());
	}
	%>

</body>
</html>