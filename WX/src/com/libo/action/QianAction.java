package com.libo.action;

import java.util.List;


import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.libo.po.Goods;
import com.libo.service.Service;
/**
 * 查询所以实物商品
 * @author 胡俊
 *	2016年10月1日 下午12:12:49
 */
@Controller
@Action(value="sw",results={@Result(name="shiwu",location="/wx/shiwu.jsp")})
public class QianAction {
	@Resource Service service;
	List<Goods> goods;
	public String showShiwu(){
		goods=service.selZai("0");
		return "shiwu";
	}
	public List<Goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
}
