<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<form action="converter/testConverter" method="post">
  		<input type="text" name="age">
  		<input type="submit" value="内置转换器">
  	</form>
  	<hr />
  	<form action="converter/stringToDateConverter" method="post">
  		<input type="text" name="birthday">
  		<input type="submit" value="自定义转换器">
  	</form>
  	<img alt="" src="<%=basePath%>statics/1.jpg">
  	
  
  </body>
</html>
