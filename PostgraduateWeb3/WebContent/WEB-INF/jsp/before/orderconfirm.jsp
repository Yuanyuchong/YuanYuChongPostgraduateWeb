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
<title>订单确认</title>
<link href="css/before/daohang.css" rel="stylesheet" type="text/css" />
<link href="css/before/common.css" rel="stylesheet" type="text/css" />
<link href="css/before/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function submitorder(total){
		if(window.confirm("是否真的提交订单，提交后不可再修改订单信息！")){
			window.location.href="orderSubmit?amount="+total;
			return true;
		}
		return false;
	}
</script> 
</head>
	<jsp:include page="head.jsp"/>
  <body>
	<div class="blank"></div>
	<div class="block clearfix"><!--当前位置-->
	<div class="location ared">当前位置：<a href="before?id=0">首页</a> > 购物流程 > 确认订单信息</div>
	<div class="blank"></div>
			<div class="nFlowBox">
    <h6>商品列表</h6>
             <table width="100%" align="center" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
            <tr>
              <th bgcolor="#ffffff">商品名称</th>
              <th bgcolor="#ffffff">市场价格</th>
              <th bgcolor="#ffffff">购买数量</th>
              <th bgcolor="#ffffff">小计</th>
            </tr> 
            	<c:forEach var="ce" items="${cartlist}">
            <tr>
              <td bgcolor="#ffffff" align="center">
                  	${ce.cname }
              </td>
              <td align="center" bgcolor="#ffffff">${ce.crprice}</td>
              <td align="center" bgcolor="#ffffff">
                ${ce.shoppingnum }
              </td>
              <td align="center" bgcolor="#ffffff">￥&nbsp;${ce.smallsum }&nbsp;元 </td>
            </tr>
     			</c:forEach>
       	  	<tr>
       	  		<td bgcolor="#ffffff" colspan="4" align="right">
       	 			应付款 
       	 			<font class="pricetype" size="5" color="red">￥&nbsp;${total }&nbsp;元</font>  	
              </td>
          </tr>   	
        </table>   
        <div align="center" style="margin:8px auto;">
       		 <img style="cursor:pointer;"  onclick="submitorder('${total}')" src="images/before/bnt_subOrder.gif" />
    	</div> 
    	<input type="hidden" name="amount" value="20"/>

</div>
</div>
</body>
</html>




