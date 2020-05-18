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
<title>初始界面</title> 
</head>
<body>
<h1><a href="first">Post管理系统的跳转链接</a></h1>
<h1><a href="before">Post辅导机构学生端</a></h1>
</body>
</html>