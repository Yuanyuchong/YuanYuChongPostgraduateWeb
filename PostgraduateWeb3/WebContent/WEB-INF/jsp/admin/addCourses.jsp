<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<title>addGoods.jsp</title>
<link href="css/admin/common.css" type="text/css" rel="stylesheet">
</head>    
<body>
<form:form action="adminCourses/addCourses" method="post" modelAttribute="courses"
	enctype="multipart/form-data">
	<table border=1 style="border-collapse: collapse">
		<caption>
			<font size=4 face=华文新魏>添加课程</font>
		</caption>
		<tr>
			<td>名称<font color="red">*</font></td>
			<td>
				<form:input path="cname"/>
			</td>
		</tr>
		<tr>
			<td>原价<font color="red">*</font></td>
			<td>
			<form:input path="coprice"/>
			</td>
		</tr>
		<tr>
			<td>折扣价</td>
			<td>
			<form:input path="crprice"/>
			</td>
		</tr>

		<tr>
			<td>图片</td>
			<td>
				<input type="file" name="logoImage"/>
			</td>
		</tr>
		<tr>
			<td>类型</td>
			<td>
		 	<form:select path="coursestype_id">
					<form:options items="${coursesType }" 
					itemLabel="typename"
					itemValue="id"/>
			</form:select> 
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
