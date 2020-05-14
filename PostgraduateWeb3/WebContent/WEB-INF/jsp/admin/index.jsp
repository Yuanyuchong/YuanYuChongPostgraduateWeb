<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主页index页面</title>
<style type="text/css">
#logo1 {
	height: 20px;
	width: 1500px;
	line-height: 2em;	
	text-align: center;
	padding: 10px;
	font-size: 18px;
}
#footer {
	height: 20px;
	width: 780px;
	line-height: 2em;
	text-align: center;
	background-color: PaleGreen;
	padding: 10px;
	font-size: 10px;
}
#mf li a:hover {
	background-color: #006633;
	color: #FFFFFF;
}
</style>
<link href="images/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="javascript/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('.menu').height($(window).height()-51-27-26);
	$('.sidebar').height($(window).height()-51-27-26);
	$('.page').height($(window).height()-51-27-26);
	$('.page iframe').width($(window).width()-15-168);
	$('.btn').click(function(){
 	$('.menu').toggle();
	if($(".menu").is(":hidden")){
	$('.page iframe').width($(window).width()-15+5);
		}else{
	$('.page iframe').width($(window).width()-15-168);
				}
		}); 
	$('.subMenu a[href="#"]').click(function(){
		$(this).next('ul').toggle();
		return false;
		});
})
</script>
</head>

<body>
	<div id="header">
    <div class="logo fleft">
   	 <div id="logo1"><Strong>Post管理员界面</Strong></div>
   	</div>
    <a class="logout fright" href="admin/login"> </a>
    <div class="clear"></div>
 	<div class="subnav">
    	<div class="subnavLeft fleft"></div>
        <div class="fleft"></div>
        <div class="subnavRight fright"></div>
    </div> 
    </div>
    <div id="content">
                <li class="subMenu"><a href="admin/toMain" target="f1">返回首页</a></li>
    
    <div class="space"></div>
    <div id="mf" class="menu fleft">
    	<ul>
        	<li class="subMenuTitle">管理界面</li>	
            <li class="subMenu"><a href="#">课程管理</a>
            	<ul>
                    <li><a href="adminCourses/toAddCourses" target="f1">添加课程</a></li>
                    <li><a href="adminCourses/selectCourses?act=updateSelect" target="f1">修改课程</a></li>
                    <li><a href="adminCourses/selectCourses" target="f1">查看课程</a></li>
                    <li><a href="adminCourses/selectCourses?act=deleteSelect" target="f1">删除课程</a></li>
                    
                </ul>
            </li>
            <li class="subMenu"><a href="#">类型管理</a>
            	<ul>
                    <li><a href="adminType/toAddType" target="f1">添加类型</a></li>
                    <li><a href="adminType/toDeleteType" target="f1">删除类型</a></li>
                </ul>
            </li>
            <li class="subMenu"><a href="#">用户管理</a>
            	<ul>
                    <li><a href="adminUser/userInfo" target="f1">删除用户</a></li>
                </ul>
            </li>
            <li class="subMenu"><a href="#">订单管理</a>
                <ul>
                    <li><a href="adminOrder/orderInfo" target="f1">删除订单</a></li>
                </ul>
            </li>
            <li class="subMenu"><a href="#" >公告管理</a>
            	<ul>
                    <li><a href="adminNotice/toAddNotice" target="f1">添加公告</a></li>
                    <li><a href="adminNotice/deleteNoticeSelect" target="f1">删除公告</a></li>
                    
                </ul>
            </li>
			<li class="subMenu"><a href="admin/login">安全退出</a></li>
            <li class="subMenu"><a href="admin/toMain" target="f1">返回首页</a></li>
            
        </ul>
    </div>
    <div class="sidebar fleft"><div class="btn"></div></div>
    <div class="page">
    <iframe src="admin/toMain" id="f1" name="f1" width="100%" scrolling="auto" height="100%" frameborder="true" allowtransparency="true" style="border: medium none;"></iframe>
    </div>
    </div>
    <div class="clear"></div>
	<div id="footer">YYC毕业设计</div>

</body>
</html>
