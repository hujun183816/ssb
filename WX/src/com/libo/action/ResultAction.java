package com.libo.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import com.libo.po.Order;
import com.libo.service.Service;
import com.libo.util.GetWxOrderno;

import net.sf.json.JSONObject;
/**
 * 鎺ュ彈鏀粯缁撴灉骞朵笖鐢熸垚璁㈠崟
 * @author 鑳′繆
 *	2016骞�10鏈�1鏃� 涓嬪崍3:53:23
 */
//@Controller
public class ResultAction {
	@Resource Service service;
	@Action(value="notifyServlet")
	public void createOrder(){
		System.out.println("进入回调");
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		Map< String, String> map=new HashMap<String, String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		String line = null;
		StringBuilder sb = new StringBuilder();
		try {
			while((line = br.readLine())!=null){
				sb.append(line);
			}
			System.out.println(sb);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			map=GetWxOrderno.doXMLParse(sb.toString());
			if(map.get("return_code").equalsIgnoreCase("success")){
				System.out.println("支付成功");
				Order order=new Order();
				order.setMoney(map.get("total_fee"));
				//处理商家数据包
				String attach=map.get("attach");
				System.out.println(attach);
				JSONObject json=JSONObject.fromObject(attach);
				order.setAdress(json.getString("adress"));
				order.setPhone(json.getString("phone"));
				order.setName(json.getString("name"));
				order.setRemark(json.getString("remark"));
				order.setPaytime(new SimpleDateFormat ("yyyy/MM/dd HH:mm").format(new Date()));
				order.setStatus(0);
				service.saveOrder(order);
				//返回给微信xml
				String backxml="<xml>"+
						"<return_code><![CDATA[SUCCESS]]></return_code>"+
						"<return_msg><![CDATA[OK]]></return_msg>"+"</xml>";
				response.getWriter().print(backxml);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//sb为微信返回的xml

	}
}