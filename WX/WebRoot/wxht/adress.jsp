<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>发货</title>

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
#first {
	margin-top: 100px;
	margin-left: 10%;
}

.table {
	width: 80%;
	margin-left: 10%
}
</style>
</head>

<body>
	<div id=first>
		<input type=button value=上传实物商品 class=btn-success
			onclick="location.href='wxht/up.jsp'" /> <input type=button
			value=代发货订单 class=btn-success onclick="location.href='selOrderDai'" />
		<input type=button value=在售商品 class=btn-success
			onclick="location.href='zaiShou'" />

	</div>
	<div>
		<form action="fahuo" method=post>
			<input type=hidden value="${order.id}" name=order.id />
			<table class=table>
				<thead>
					<tr>

						<th>物流公司 &nbsp;&nbsp;&nbsp;<textarea name=order.company></textarea></th>
						<th>物流单号&nbsp;&nbsp;&nbsp; <textarea name=order.num></textarea></th>
						<th>备注&nbsp;&nbsp;&nbsp; <textarea id=bbbzhu name=order.remark ></textarea></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type=submit value=发货 class=btn-success /></td>
						<td><input type=button value=发货失败 class=btn-success
							onclick="fail()" /></td>
					</tr>
				</tbody>

			</table>
		</form>
		<script>
			function fail(){
				var vu=$('#bbbzhu').html();
				location.href='fahuo2?order.id=${order.id}&&order.remark='+vu;
			}
		</script>
	</div>
</body>
</html>
