<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${name }
<hr/>
<h2>从表单中取值</h2>
编号：${sessionUser.id }
姓名：${sessionUser.username }
年龄${sessionUser.age }
<hr/>
<h2>从session中取值</h2>
编号：${sessionScope.sessionUser.id }
姓名：${sessionScope.sessionUser.username }
年龄${sessionScope.sessionUser.age }
<hr/>
<h2>从ModelAttribute方法中取值</h2>
${cityList }
</body>

</html>