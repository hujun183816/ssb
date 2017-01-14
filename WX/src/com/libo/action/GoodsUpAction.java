package com.libo.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.libo.po.Goods;
import com.libo.service.Service;

@Controller
public class GoodsUpAction {
	@Resource Service service;
	private List<Goods> goods;
	private int goodid;
	
	/**
	 * 在售 商品
	 * @return
	 */
	@Action(value="zaiShou",results={@Result(name="success",location="/wxht/zaishou.jsp")})
	public String AllZai(){
		goods=service.selZai("0");
		return "success";
	}
	
	/**
	 * 下架 
	 * @return
	 */
	@Action(value="xiajia",results={@Result(name="success",type="redirect",location="zaiShou")})
	public String xiajia(){
		Goods good=service.selGoodsOne(goodid);
		good.setStatus(1);
		service.updateGood(good);
		return "success";
	}
	
	
	public List<Goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	public int getGoodid() {
		return goodid;
	}
	public void setGoodid(int goodid) {
		this.goodid = goodid;
	}
}
