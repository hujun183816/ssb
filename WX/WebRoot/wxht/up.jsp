<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>   管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
		<input type=button value=上传实物商品 class= btn-success />
		<input type=button value=代发货订单 class= btn-success onclick="location.href='selOrderDai'"/>
		<input type=button value=在售商品  class= btn-success onclick="location.href='zaiShou'" />
		
	</div>
	<div>
		<form action=up!upl  method=post enctype="multipart/form-data" >
			<table class=table >
			<thead>
				<tr>
					<th>商品标题   &nbsp;&nbsp;&nbsp;<input type=text name=goods.name /></th>
					
				</tr>
				<tr>
					<th>商品图片   &nbsp;&nbsp;&nbsp;<input type=file name=file /></th>
					
				</tr>
					<tr>
					<th>商品价格   &nbsp;&nbsp;&nbsp;<input type=text name=goods.price /> </th>
					
				</tr>
					<tr>
					
					<th>商品详情 &nbsp;&nbsp;&nbsp; <textarea name=goods.content ></textarea></th>
				</tr>
					<tr>
				
					<th>备注  &nbsp;&nbsp;&nbsp; <textarea name=goods.beizhu ></textarea></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type=submit value=上传 class= btn-success /></td>
				</tr>
			</tbody>
			
			</table>
		
		</form>
	</div>
  </body>
</html>
