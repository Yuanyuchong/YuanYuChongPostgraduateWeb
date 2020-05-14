<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>公告详情页面</title>
</head>
<body>
<table border=1 style="border-collapse: collapse">
		<caption>
			<font size=4 face=华文新魏>公告详情</font>
		</caption>
			<tr>
			<td>公告标题</td>
			<td>
				<h1 align="center">${notice.ntitle}</h1>
			</td>
		</tr>
		<tr>
			<td>公告内容</td>
			<td>
				${notice.ncontent}
			</td>
		</tr>
		</table>
	<p align="left">公告发表时间：<br>${notice.ntime}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>				
</body>
</html>