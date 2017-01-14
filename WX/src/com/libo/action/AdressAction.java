package com.libo.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

@Controller
public class AdressAction {
	private String money;
	private String describe;
	private String body;

	
	@Action(value ="adress",results={@Result(name="success",location="/adress.jsp")})
	public String  adr(){
		return "success";
	}
	@Action(value ="adresssw",results={@Result(name="success",location="/adress.jsp")})
	public String  adrsw(){
		String[] str=body.split("/");
		describe=str[0];
		money=str[1];
		return "success";
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
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
