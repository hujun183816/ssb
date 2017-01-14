
function two(a){
	location.href='sw!showShiwu'
		
}
function three(a){
	location.href='wx/order.jsp'
		
}
//二级js
function erji0(a){
	//添加三级目录,用户点击影视会员的时候，三级目录代码会变成这样，这里要和之前那个对应起来
	$('#sanji1').empty()
	$('#sanji1').append('<button class="btn sanji " value=5.0 >爱奇艺7天</button>'+
			'<button class="btn sanji ">爱奇艺30天</button>'+
			'<button class="btn sanji">优酷7天</button><br>'+
	'<button class="btn sanji ">优酷30天</button>'+
	'<button class="btn sanji " value=30.0 >优酷30天</button>'
	
	
	)
	$('.erji').css({"border":'5px solid #dfe0e5'})
	$(a).css({"border":'5px solid #0fae6e'})

}
function erji1(a){
	//添加三级目录，用户点击台州话费的时候，
	//三级目录下面的代码变成这样，改名字和价格。下面所有的三级目录一样的改法
	$('#sanji1').empty()
	$('#sanji1').append('<button class="btn sanji ">50话费</button>'+
			'<button class="btn sanji">100话费</button>'+
			'<button class="btn sanji">150话费</button><br>'+
	'<button class="btn sanji">200话费</button><br>')
	$('.erji').css({"border":'5px solid #dfe0e5'})
	$(a).css({"border":'5px solid #0fae6e'})

}
function erji2(a){
	//添加三级目录
	$('#sanji1').empty()
	$('#sanji1').append('<button class="btn sanji ">电子券0</button>'+
			'<button class="btn sanji ">电子券1</button>'+
			'<button class="btn sanji">电子券2</button><br>'+
	'<button class="btn sanji ">电子券3</button><br>')
	$('.erji').css({"border":'5px solid #dfe0e5'})
	$(a).css({"border":'5px solid #0fae6e'})

}
function erji3(a){
	//添加三级目录
	$('#sanji1').empty()
	$('#sanji1').append('<button class="btn sanji ">业务一</button>'+
			'<button class="btn sanji ">业务一</button>'+
			'<button class="btn sanji">业务一</button><br>'+
	'<button class="btn sanji ">业务一</button><br>')
	$('.erji').css({"border":'5px solid #dfe0e5'})
	$(a).css({"border":'5px solid #0fae6e'})

}
function erji4(a){
	//添加三级目录
	$('#sanji1').empty()
	$('#sanji1').append('<button class="btn sanji ">业务2</button>'+
			'<button class="btn sanji ">业务2</button>'+
			'<button class="btn sanji">业务2</button><br>'+
	'<button class="btn sanji ">业务2</button><br>')
	$('.erji').css({"border":'5px solid #dfe0e5'})
	$(a).css({"border":'5px solid #0fae6e'})

}
function erji5(a){
	//添加三级目录
	$('#sanji1').empty()
	$('#sanji1').append('<button class="btn sanji ">业务3</button>'+
			'<button class="btn sanji ">业务3</button>'+
			'<button class="btn sanji">业务3</button><br>'+
	'<button class="btn sanji ">业务3</button><br>')
	$('.erji').css({"border":'5px solid #dfe0e5'})
	$(a).css({"border":'5px solid #0fae6e'})

}
//页面加载完毕给所有三级目录绑定
$(document).ready(function(){
	//刚进页面默认样式
	$('#xn').css({"border":'5px solid #0fae6e'})
	$('#xn').addClass("boxshadow")
	$('#ys').css({"border":'5px solid #0fae6e'})
	$('#ys').addClass("boxshadow")
	//给一级目录添加点击 事件
	$('.yi').click(function(){
		$('.yi').css({"border":'5px solid #dfe0e5'})
		$('.yi').removeClass("boxshadow")
		$(this).css({"border":'5px solid #0fae6e'})
		$(this).addClass("boxshadow")
	})
	//给所有二级目录绑定
	$('.erji').click(function(){
		$('.erji').css({"border":'5px solid #dfe0e5'})
		$('.erji').removeClass("boxshadow")
		$(this).css({"border":'5px solid #0fae6e'})
		$(this).addClass("boxshadow")
		//给所有三级目录绑定
		$("#sanji1>button").click(function(){
			$('.sanji').css({"border":'5px solid #dfe0e5'})
			$('.sanji').removeClass("boxshadow")
			$(this).css({"border":'5px solid #0fae6e'})
			$(this).addClass("boxshadow")
			$(this).attr("name","1")
			var price=$(this).val()
			$('#pay').html("立即支付 ： "+price+"元")
		})
		
	})
	//给所有三级目录绑定
		$("#sanji1>button").click(function(){
			$('.sanji').css({"border":'5px solid #dfe0e5'})
			$('.sanji').removeClass("boxshadow")
			$(this).css({"border":'5px solid #0fae6e'})
			$(this).addClass("boxshadow")
			$(this).attr("name","1")
			var price=$(this).val()
			$('#pay').html("立即支付 ： "+price+"元")
		})

})
//支付按钮
function pay(){
	var money=$("#sanji1>button[name=1]").val()
	var describe=$("#sanji1>button[name=1]").html()
	if(typeof(money)!="undefined"){
		location.href='adress?money='+money+'&&describe='+describe
	}else{
		alert('请选择具体业务！')
	}

}

