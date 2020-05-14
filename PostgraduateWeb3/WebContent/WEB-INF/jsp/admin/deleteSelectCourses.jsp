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
    <title>课程删除页面</title>
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
		function changeColor(obj){
			obj.className = "bgcolor";
		}
		function changeColor1(obj){
			obj.className = "";
		}
	</script>
	<script type="text/javascript">
  		
  		function checkDel(id){
  			if(window.confirm("是否删除该课程？")){
  				window.location.href = "adminCourses/deleteACourses?id="+id;
  			}
  		}
  </script>
</head>
<body>
<c:if test="${allCourses.size()==0 }">
		您还没有商品
	</c:if>
	<c:if test="${allCourses.size()!=0 }">
	<form action=" " name="deleteForm">
		<table border="1" bordercolor="PaleGreen">
			<tr>
				<th width="100px">ID</th>
				<th width="200px">名称</th>
				<th width="200px">价格</th>
				<th width="100px">详情</th>
				<th width="100px">操作</th>
			</tr>
		<c:forEach items="${allCourses}" var="courses">
		<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
			<td>${courses.id }</td>
			<td>${courses.cname }</td>
			<td>${courses.crprice }</td>
			<td><a href="adminCourses/selectACourses?id=${courses.id }" target="_blank">详情</a></td>
			<td><a href="javascript:checkDel(${courses.id })">删除</a></td>
		</tr>
		</c:forEach>
	
			<tr>
			<td colspan="5" align="right">
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;共${totalCount }条记录&nbsp;&nbsp;共${totalPage }页&nbsp;&nbsp;
				第${pageCur }页&nbsp;&nbsp;
				<c:url var="url_pre" value="adminCourses/selectCourses?act=deleteSelect">
					<c:param name="pageCur" value="${pageCur-1 }"></c:param>
				</c:url>
				<c:url var="url_next" value="adminCourses/selectCourses?act=deleteSelect">
					<c:param name="pageCur" value="${pageCur+1 }"></c:param>
				</c:url>
				<!-- 第一页，没有上一页 -->
				<c:if test="${pageCur!=1}">
					<a href="${url_pre}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<!-- 最后一页，没有下一页 -->
				<c:if test="${pageCur!=totalPage&&totalPage!=0}">
					<a href="${url_next}">下一页</a>
				</c:if>
			</td>
		</tr> 
		<tr>
			<td colspan="3">${msg }</td>
		</tr>
		</table>
	</form>
	</c:if>
</body>
</html>