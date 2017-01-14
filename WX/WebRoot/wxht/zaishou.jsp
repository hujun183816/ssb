<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="bootstrapmin/bootstrap.min.css">
<script type="text/javascript" src="bootstrapmin/bootstrap.min.js"></script>
<script type="text/javascript" src="jquery/jquery.min.js"></script>

<style>
	#first{margin-top:100px;margin-left:10%;}
	.table{width:80%;margin-left:10%}
</style>
  </head>
  
  <body>
	<div id=first >
		<input type=button value=上传实物商品 class= btn-success onclick="location.href='wxht/up.jsp'"/>
		<input type=button value=代发货订单 class= btn-success onclick="location.href='selOrderDai'"/>
		<input type=button value=在售商品  class= btn-success onclick="location.href='zaiShou'" />
		
	</div>
	<div>
		<table class=table >
			<thead>
				<tr>
					<th>商品名  &nbsp;&nbsp;&nbsp;</th>
					<th>价格   &nbsp;&nbsp;&nbsp;</th>
					<th>详情   &nbsp;&nbsp;&nbsp;</th>
					<th>备注&nbsp;&nbsp;&nbsp; </th>
					<th>图片  &nbsp;&nbsp;&nbsp; </th>
					<th>操作 &nbsp;&nbsp;&nbsp; </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${goods}" var="good">
				<tr>
					<td>${good.name }</td>
					<td>${good.price }</td>
					<td>${good.content }</td>
					<td>${good.beizhu }</td>
					<td><img src="${good.image }" ></td>
					<td><input type=button value=下架
					  class= btn-success onclick="fahuo('${good.id }')" /></td>
				</tr>
				</c:forEach>
			</tbody>
			
			</table>
			<script>
				function fahuo(a){
					location.href='xiajia?goodid='+a
				}
			</script>
	</div>
  </body>
</html>
