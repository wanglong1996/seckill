<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>秒杀列表展示</title>
<%@include file="common/tag.jsp" %>
</head>
<body>
	<div class="container">
		<h2>秒杀列表</h2>
		<c:forEach var="sk" items="${list }">
		<tr>
			<td>${sk.name }</td>
			<td>${sk.number }</td>
			<td>
				<fmt:formatDate value = "${sk.startTime }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
			</td>
			<td>
				<fmt:formatDate value = "${sk.endTime }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
			</td>
			<td>
				<fmt:formatDate value = "${sk.createTime }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
			</td>
			<td>
				<a class="btn" href="/seckill/${sk.seckillId }/detail">Link</a>
				
			</td>
		</tr><br>
		
		</c:forEach>
	</div>

</body>
</html>