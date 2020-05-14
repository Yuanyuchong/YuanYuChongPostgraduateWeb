<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
   String path =request.getContextPath();
   String basePath =request.getScheme()+"://"+request.getServerName()+":"
   +request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<head>

  <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理员页面</title>
<style type="text/css">
#footer {
	line-height: 2em;
	text-align: center;
	padding: 10px;
	font-size: 15px;
		}
.textSize{
		width: 120px;
		height: 25px;
	}
* {
		margin: 0px;
		padding: 0px;

</style>
<head>
<link href="images/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
	//确定按钮
	function gogo(){
		document.forms[0].submit();
	}
	//取消按钮
	function cancel(){
		document.forms[0].action = "";
	}
	</script>

</head>
<body>
   <div id="wrap">
	<div id="header"> </div> 
		<h2 align="center">欢迎yuan${auser.aname}进入管理员界面</h2><br>
		<h2 align="center">通过左侧按钮选择你所需要的操作</h2>
		
    <div class="space"> </div>
    <div class="content">
   
      </div>
    </div>
</body>
</html>
