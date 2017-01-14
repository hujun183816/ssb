手机号：<input id=phone type=text /><input type="button" value=查询 onclick=selOrder() />
<script>
	function selOrder(){
		var phone=$("#phone").val()
		$.post("selPhone",{"phone":phone},function(data){
			var orders=$.parseJSON(data)
			alert(orders.phone)
		})
	}
</script>
<table>
	<tr>
		
	</tr>
</table>