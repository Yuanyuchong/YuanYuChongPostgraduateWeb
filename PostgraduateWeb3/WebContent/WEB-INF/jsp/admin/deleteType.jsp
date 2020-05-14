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
<title>Insert title here</title>
<link href="css/admin/common.css" type="text/css" rel="stylesheet">
	<style type="text/css">
		table{
			text-align: center;
			border-collapse: collapse;
		}
		.bgcolor{
		  	background-color: #F08080;
		}
	</style>
	<script type="text/javascript">
  		function checkDel(id){
  			if(window.confirm("是否删除该商品类型？")){
  				window.location.href ="adminType/deleteType?id="+id;
  			}
  		}
/* 			window.location.href = "/ch20/adminType/deleteType?id="+id;
 */
  </script>
</head>
<body>
	<table border="1" bordercolor="PaleGreen" >
		<tr>
			<th width="200px">类型ID</th>
			<th width="300px">类型名称</th>
			<th width="300px">删除操作</th>
		</tr>

			<c:forEach items="${allTypes }" var="coursesType">
				<tr>
					<td>${coursesType.id }</td>
					<td>${coursesType.typename }</td>
					<td><a href="javascript:checkDel('${coursesType.id }')">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3">${msg }</td>
			</tr>
	
	</table>
</body>
</html>