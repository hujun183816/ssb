package com.libo.action;

import java.io.IOException;

import java.net.URLEncoder;


import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.stereotype.Controller;

import com.libo.util.Sha1Util;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 微信支付接口
 * 
 * @author 胡俊 2016年9月30日 下午8:27:50
 */
@SuppressWarnings("serial")
@Controller
public class MainAction extends ActionSupport {
	private String money;
	private String describe;
	private String phone;
	private String adress;
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private String remark;
	@Action(value = "auth")
	public void main() {
		String appid = "wx29ebd38093d2298b";// 商户参数
		String backUri = "http://www.yunll.cc/topayServlet";// 网页授权后要跳的链接
		String orderNo = appid + Sha1Util.getTimeStamp();
//		backUri = backUri + "?userId=bddd&orderNo=" + orderNo + "&describe="+describe+"&money="+money;
		backUri = backUri + "?userId=bddd&orderNo=" + orderNo + "&describe="+describe+"&money="+money+"&phone="+phone+"&adress="+adress+"&remark="+remark;
		backUri = URLEncoder.encode(backUri);
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" + "appid=" + appid + "&redirect_uri="
				+ backUri + "&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
		try {
			ServletActionContext.getResponse().sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
}