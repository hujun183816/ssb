<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>填写物流地址</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
.tableo {
	width: 80%;
	margin-left: 17%;
	font-size: 40px;
	margin-top: 100px;
	line-height: 300%;
}
html{
	font-size:62.5%;
}
</style>
</head>

<body>
	<div
		style="width:80%;height:1000px;border:#A8CB31 1px solid;border-radius:20px;margin-top:20%;margin-left:10%">
		<form action="auth" method=post>
			<input type=hidden name=money value=${money } /> <input type=hidden
				name=describe value=${describe } />
			<script>
				function phoneCheck(a) {
					
					var value=$(a).val()
					if (!/^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/i.test(value)) {
						alert('请输入正确的手机号');
					}
				}
			</script>
			<table class=tableo>
				<tr>
					<td width=30% >手机号</td>
					<td><input onblur=phoneCheck(this) type=text name=phone
						style="width:70%;height:80px;font-size:50px" /></td>
				</tr>
				<tr>
					<td width=30%>物流地址</td>
					<td><textarea name=adress
							style="width:70%;height:200px;font-size:50px"></textarea></td>
				</tr>
				<tr>
					<td width=30%>备注</td>
					<td><textarea name=remark
							style="width:70%;height:200px;font-size:50px"></textarea></td>
				</tr>
			</table>

			<input type="submit" value=提交订单 onclick=selOrder() class="btn"
				style="margin-left:30%;margin-top:10%;background:#A8CB31;width:28rem;height:80px;font-size:40px;border-radius:20px;color:white;" />
		</form>
	</div>
</body>
</html>
