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
		<h1 align="center">Post考研辅导管理员登录页面</h1>
    <div id="content-wrap">
    <div class="space"> </div>
    <div class="content">
    <form:form action="admin/login" modelAttribute="auser" method="post">
   	  	<div class="content">
        <div class="field"><label>账　户：</label><form:input  path="aname" cssClass="textSize" />
 </div>
		<div class="field"><label>密　码：</label><form:password path="apwd" cssClass="textSize"/>
<br /></div>
<%--         <div class="field"><label>验证码：</label><form:input path="" cssClass="textSize" /><br /></div>
 --%>		<tr><td colspan="2">
				<input type="image" src="images/admin/11.png" onclick="gogo()" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="image" src="images/admin/acancel.png" onclick="cancel()" >
			</td>
		</tr>
		</form:form>
      </div>
    </div>
    ${msg }
    <div id="footer">@YYC毕业设计 </div> 
</body>
</html>
