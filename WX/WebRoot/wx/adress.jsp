<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>填写物流地址</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		.tableo{width:90%;margin-left:20px;font-size:2em;margin-top:20px}
	</style>
  </head>
  
  <body>
  <div style="width:80%;height:60%;border:#A8CB31 1px solid;border-radius:20px;margin-top:20%;margin-left:10%">
  <form action="auth" method=post >
  <input type=hidden name=money value=${money} />
  <input type=hidden name=describe value=${describe} />
  
   <table class=tableo  >
   <tr>
   	<td width="20%">手机号</td>
   	<td><input  type="text" name="phone" style="width:100%;height:2em;font-size:2em;line-height:2em;" /></td>
   </tr>
    <tr>
   	<td>物流地址</td>
   	<td><textarea name="adress" style="width:100%;height:4em;font-size:2em;line-height:2em;"  ></textarea></td>
   </tr>
    <tr>
   	<td>备注</td>
   	<td><textarea name="remark" style="width:100%;height:4em;font-size:2em;line-height:2em;" ></textarea></td>
   </tr>
   </table>
   
   <input type="submit" value=提交订单  onclick="selOrder()"  class="btn" style="margin:20px auto;display:block;background:#A8CB31;width:30%;height:3em;font-size:2em;border-radius:5px;border:none;color:#fff;" />
   </form>
   </div>
  </body>
</html>
