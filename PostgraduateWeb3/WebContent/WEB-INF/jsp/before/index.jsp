<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>首页</title>
<link href="css/before/daohang.css" rel="stylesheet" type="text/css" />
<link href="css/before/common.css" rel="stylesheet" type="text/css" />
<link href="css/before/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
		function openNotice(url){
			window.open (url, '站内公告', 'height=400, width=400, top=100, left=100, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=n o, status=no');
		}
</script>
</head>
<body>
	<jsp:include page="head.jsp"/>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="AreaL">
			<!--销售排行-->
			<div class="box">
				<div class="box_2">
					<div class="top10Tit">
						<span>销售排行</span>
					</div>
						<c:forEach var="s" items="${salelist}">
					<div class="top10List clearfix">
							<ul class="clearfix">
								<img class="iteration" src="images/before/top_1.gif" />
								<li class="topimg">
								<a href="coursesDetail?id=${s.id }" target="_blank"> 
									<c:if test="${s.cpicture!=' '}">
									<img alt="" width="25" height="25" src="logos/${s.cpicture}"/>
									</c:if>
								</a></li>
								<li class="iteration1">
								<a href="coursesDetail?id=${s.id }" target="_blank">${s.cname}</a><br />
								 售价：<font class="f1">${s.coprice}</font><br /></li>
							</ul>
					</div>
					</c:forEach>
				</div>
			</div>
			<!--销售排行 end -->
			<!--人气排行-->
			<div class="blank5"></div>
			<div class="box">
				<div class="box_2">
					<div class="top10Tit">
						<span>人气排行</span>
					</div>
					<c:forEach var="f" items="${focuslist}">
					<div class="top10List clearfix">
						<ul class="clearfix">
								<img class="iteration" src="images/before/top_1.gif" />
								<li class="topimg">
								<a href="coursesDetail?id=${f.id }" target="_blank"> 
									<c:if test="${f.cpicture!=' '}">
									<img alt="" width="25" height="25" src="logos/${f.cpicture}"/>
									</c:if>
								<li class="iteration1">
								<a href="coursesDetail?id=${f.id }" target="_blank">${f.cname}</a><br />
								 售价：<font class="f1">${f.coprice}</font><br /></li>
							</ul>
					</div>
					</c:forEach>
					
				</div>
			</div>
			<!--人气排行 end -->
		</div>
		<div class="AreaR">
			<div class="AreaR">
				<div class="AreaM clearfix">
					<div id="focus">
						<img src="images/before/540.jpg" />
					</div>
				</div>
				<div class="AreaRR clearfix">
					<!--公告栏-->
					<div class="box">
						<div class="box_1">
							<div class="title_bt">
								<h3>公告栏</h3>
							</div>
							<div class="post_list ared">
								<ul>
								<c:forEach var="n" items="${noticelist}">
									<li><a href="javascript:openNotice('adminNotice/selectANotice?id=${n.id }');">
									${n.ntitle}</a></li>
								</c:forEach>									
								</ul>
							</div>
						</div>
					</div>
					<!--公告栏 end-->
				</div>
			</div>
			<div class="AreaR">
				<!--最新商品列表-->
				<div class="blank5"></div>
				<div class="box">
					<div class="box_color ared">
						<div class="title_bt">
							<span><a href="#">更多</a></span>
							<h3>最新课程</h3>
						</div>
						<div class="itemgood_nr clearfix">
							<ul>
								<c:forEach var="l" items="${lastedlist}">
									<li>
										<div>
											<p class="pic">
												<a href="coursesDetail?id=${l.id }" target="_blank">
												<c:if test="${f.cpicture!=' '}">
													<img alt="" width="25" height="25" src="logos/${l.cpicture}"/>
												</c:if>
												</a>
											</p>
											<p class="wz">
												<strong><a href="coursesDetail?id=${l.id }" target="_blank">${l.cname}</a></strong>
												<em>现价:<span>${l.coprice}</span></em>
											</p>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<!--最新商品列表end-->
			</div>
		</div>
	</div>
</body>
</html>
