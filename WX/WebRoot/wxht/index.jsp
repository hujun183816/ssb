<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台</title>
    
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
<script>
	$(function(){
		$('#vut').click(function(){
			var pwd=$('#tex').val()
			if(pwd=='123456'){
				location.href='wxht/up.jsp'
			}
		})
	})
</script>
  </head>
  
  <body>
   <input id=tex type=text />
   <input id=vut type=button value=进入  class=btn-success />
  </body>
</html>
