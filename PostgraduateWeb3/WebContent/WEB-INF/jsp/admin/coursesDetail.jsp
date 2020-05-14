<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   String path =request.getContextPath();
   String basePath =request.getScheme()+"://"+request.getServerName()+":"
   +request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程详情</title>
</head>
<body>
	<table border=1 style="border-collapse: collapse">
		<caption>
			<font size=4 face=华文新魏>课程详情</font>
		</caption>
		<tr>
			<td>名称</td>
			<td>
				${courses.cname }
			</td>
		</tr>
		<tr>
			<td>原价</td>
			<td>
				${courses.coprice }
			</td>
		</tr>
		<tr>
			<td>折扣价</td>
			<td>
				${courses.crprice }
			</td>
		</tr>
		<tr>
			<td>图片</td>
			<td>
				<c:if test="${courses.cpicture!=' '}">
					<img alt="" width="250" height="250" src="logos/${courses.cpicture}"/>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>类型</td>
			<td>
				${courses.typename }
			</td>
		</tr>
	</table>
</body>
</html>