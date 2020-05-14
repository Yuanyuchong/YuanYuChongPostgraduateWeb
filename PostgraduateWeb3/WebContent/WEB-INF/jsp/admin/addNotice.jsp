<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>addNotice.jsp</title>
<link href="css/admin/bootstrap.css" type="text/css" rel="stylesheet">
	
	<style type="text/css">
		/*table{
			text-align: center;
			border-collapse: collapse;
		}*/
		.bgcolor{
		  	background-color: #d9edf7;
		}
		th{
		background-color: #d9edf7;
		
		}
		/* Border styles */
		table thead, table tr {
		border-top-width: 1px;
		border-top-style: solid;
		border-top-color: #9EC3ED;
		}
		table {
		border-bottom-width: 1px;
		border-bottom-style: solid;
		border-bottom-color: #9EC3ED;
		}
		
		/* Padding and font style */
		table td, table th {
		padding: 5px 10px;
		font-size: 12px;
		font-family: Verdana;
		color: rgb(177, 106, 104);
		}
		
		/* Alternating background colors */
		/*#table tr:nth-child(even) {
		background: #d9edf7        /*#CFD0CF*/
		}*/
		/*#table tr:nth-child(odd) {
		/*background: #FFF
		}*/
	</style>
</head>    
<body>
	<form:form action="adminNotice/addNotice" method="post" modelAttribute="notice">
		<table border=1 style="border-collapse: collapse">
			<caption>
				<font size=4 face=华文新魏>添加公告</font>
			</caption>
			<tr>
				<td>标题<font color="red">*</font></td>
				<td>
					<form:input path="ntitle"/>
				</td>
			</tr>
			<tr>
				<td>内容<font color="red">*</font></td>
				<td>
					<form:textarea path="ncontent"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="submit" value="提交"/>
				</td>
				<td align="left">
					<input type="reset" value="重置"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
