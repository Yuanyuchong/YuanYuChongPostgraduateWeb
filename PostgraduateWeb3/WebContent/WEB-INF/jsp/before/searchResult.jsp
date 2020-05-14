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
<title>搜索结果</title>
<link href="css/before/daohang.css" rel="stylesheet" type="text/css" />
<link href="css/before/common.css" rel="stylesheet" type="text/css" />
<link href="css/before/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="head.jsp"/>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="location ared">当前位置： <a href="before?id=0">首页</a> > 搜索结果</div>
		<div class="blank"></div>
		<div>
			<div class="nFlowBox">
				<table width="99%" align="center" border="0" cellpadding="5"
					cellspacing="1" bgcolor="#dddddd">
					<tr>
						<th>商品编号</th>
						<th>商品名称</th>
						<th>商品图片</th>
						<th>商品价格</th>
						<th>去看看</th>
					</tr>
					<tr>
						<td colspan="5" height="15px"
							style="border: 0 none; background: #FFF"></td>
					</tr>
					<c:forEach items="${searchlist}" var="mf">
						<tr>
							<td bgcolor="#ffffff" align="center">${mf.id }</td>
							<td bgcolor="#ffffff" align="center">${mf.cname }</td>
							<td align="center" bgcolor="#ffffff" height="60px"><img
								style="width: 50px; height: 50px;"
								src="logos/${mf.cpicture }" border="0" title="${mf.cname }" />
							</td>
							<td align="center" bgcolor="#ffffff">${mf.coprice }</td>
							<td align="center" bgcolor="#ffffff"><a
								style="text-decoration: none;" class="f6"
								href="coursesDetail?id=${mf.id } " target="_blank">去看看</a></td>
						</tr>
						</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
