package com.libo.action;


import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.stereotype.Controller;

import com.libo.util.CommonUtil;
import com.libo.util.GetWxOrderno;
import com.libo.util.RequestHandler;
import com.libo.util.Sha1Util;
import com.libo.util.TenpayUtil;

import net.sf.json.JSONObject;


@Controller
public class PayAction {
	@Action(value="topayServlet")
	public void payWx(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		//缃戦〉鎺堟潈鍚庤幏鍙栦紶閫掔殑鍙傛暟
		String userId = request.getParameter("userId"); 	
		String orderNo = request.getParameter("orderNo"); 
		String money = request.getParameter("money");
		String code = request.getParameter("code");
		String describe = request.getParameter("describe");
		String phone = request.getParameter("phone");
		String adress = request.getParameter("adress");
		String remark = request.getParameter("remark");
		//閲戦杞寲涓哄垎涓哄崟浣�
		float sessionmoney = Float.parseFloat(money);
		String finalmoney = String.format("%.2f", sessionmoney);
		finalmoney = finalmoney.replace(".", "");
		//鍟嗘埛鐩稿叧璧勬枡 
		String appid = "wx29ebd38093d2298b";
		String appsecret = "cda507040f2a64ac8b2fafaf593d42f4";
		String partner = "1389451402";
		String partnerkey = "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjj1J";
		String openId ="";
		String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+appsecret+"&code="+code+"&grant_type=authorization_code";
		
		JSONObject jsonObject = CommonUtil.httpsRequest(URL, "GET", null);
		if (null != jsonObject) {
			openId = jsonObject.getString("openid");
		}
				String currTime = TenpayUtil.getCurrTime();
				String strTime = currTime.substring(8, currTime.length());
				String strRandom = TenpayUtil.buildRandom(4) + "";
				String strReq = strTime + strRandom;
				String mch_id = partner;
				String nonce_str = strReq;
				String body = describe;
				//商家数据包
				JSONObject json=new JSONObject();
				json.put("phone", phone);
				json.put("adress", adress);
				json.put("name", describe);
				json.put("remark", remark);
				String attach=json.toString();
//				String attach = phone+"!*!#"+adress+"!*!#"+describe;//闄勫姞鏁版嵁
				String out_trade_no = orderNo;//鍟嗘埛璁㈠崟鍙�
				int intMoney = Integer.parseInt(finalmoney);
				int total_fee = intMoney;//鎬婚噾棰濅互鍒嗕负鍗曚綅锛屼笉甯﹀皬鏁扮偣
				//璁㈠崟鐢熸垚鐨勬満鍣� IP
				String spbill_create_ip = request.getRemoteAddr();
				//杩欓噷notify_url鏄� 鏀粯瀹屾垚鍚庡井淇″彂缁欒閾炬帴淇℃伅锛屽彲浠ュ垽鏂細鍛樻槸鍚︽敮浠樻垚鍔燂紝鏀瑰彉璁㈠崟鐘舵�佺瓑銆�
//				String notify_url ="http://mahuan.3w.dkys.org/WX/notifyServlet";
				String notify_url ="http://www.yunll.cc/notifyServlet";
				String trade_type = "JSAPI";
				String openid = openId;
				SortedMap<String, String> packageParams = new TreeMap<String, String>();
				packageParams.put("appid", appid);  
				packageParams.put("mch_id", mch_id);  
				packageParams.put("nonce_str", nonce_str);  
				packageParams.put("body", body);  
				packageParams.put("attach", attach);  
				packageParams.put("out_trade_no", out_trade_no);  
//				packageParams.put("total_fee", "1"); //杩欓噷鍐欑殑閲戦涓�1 鍒嗗埌鏃朵慨鏀� 
				packageParams.put("total_fee", finalmoney);  
				packageParams.put("spbill_create_ip", spbill_create_ip);  
				packageParams.put("notify_url", notify_url);  
				packageParams.put("trade_type", trade_type);  
				packageParams.put("openid", openid);  
				RequestHandler reqHandler = new RequestHandler(request, response);
				reqHandler.init(appid, appsecret, partnerkey);
				String sign = reqHandler.createSign(packageParams);
				String xml="<xml>"+
						"<appid>"+appid+"</appid>"+
						"<mch_id>"+mch_id+"</mch_id>"+
						"<nonce_str>"+nonce_str+"</nonce_str>"+
						"<sign>"+sign+"</sign>"+
						"<body><![CDATA["+body+"]]></body>"+
						"<attach>"+attach+"</attach>"+
						"<out_trade_no>"+out_trade_no+"</out_trade_no>"+
						//閲戦锛岃繖閲屽啓鐨�1 鍒嗗埌鏃朵慨鏀�
//						"<total_fee>"+1+"</total_fee>"+
						"<total_fee>"+finalmoney+"</total_fee>"+
						"<spbill_create_ip>"+spbill_create_ip+"</spbill_create_ip>"+
						"<notify_url>"+notify_url+"</notify_url>"+
						"<trade_type>"+trade_type+"</trade_type>"+
						"<openid>"+openid+"</openid>"+
						"</xml>";
				System.out.println(xml);
				String allParameters = "";
				try {
					allParameters =  reqHandler.genPackage(packageParams);
				} catch (Exception e) {
					e.printStackTrace();
				}
				String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
				String prepay_id="";
				try {
					//鑾峰彇openId鍚庤皟鐢ㄧ粺涓�涓嬪崟鎺ュ彛https://api.mch.weixin.qq.com/pay/unifiedorder
					prepay_id = new GetWxOrderno().getPayNo(createOrderURL, xml);
					if(prepay_id.equals("")){
						request.setAttribute("ErrorMsg", "缁熶竴鏀粯鎺ュ彛鑾峰彇棰勬敮浠樿鍗曞嚭閿�");
						response.sendRedirect("error.jsp");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				SortedMap<String, String> finalpackage = new TreeMap<String, String>();
				String appid2 = appid;
				String timestamp = Sha1Util.getTimeStamp();
				String nonceStr2 = nonce_str;
				String prepay_id2 = "prepay_id="+prepay_id;
				String packages = prepay_id2;
				finalpackage.put("appId", appid2);  
				finalpackage.put("timeStamp", timestamp);  
				finalpackage.put("nonceStr", nonceStr2);  
				finalpackage.put("package", packages);  
				finalpackage.put("signType", "MD5");
				String finalsign = reqHandler.createSign(finalpackage);
				try {
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html;charset=utf-8");
					request.setAttribute("describe", describe);
					response.sendRedirect("pay.jsp?appid="+appid2+"&timeStamp="+timestamp+"&nonceStr="+nonceStr2+"&package="+packages+"&sign="+finalsign+"&describe="+describe+"&money="+money);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
}
