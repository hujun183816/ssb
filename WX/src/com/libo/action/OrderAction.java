package com.libo.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.libo.po.Order;
import com.libo.service.Service;
/**
 * 查询订单
 * @author 胡俊
 *	2016年10月5日 下午6:44:25
 */
@Controller
public class OrderAction {
	@Resource  Service service;
	private String phone;
	private List<Order> orders;
	private Order order;
	


	@Action(value="selPhone",results={@Result(name="success",location="/wx/order.jsp")})
	public String selPhone(){
		 orders=service.selOrder(phone);
		 return "success";
	}
	/**
	 * 后台查询所有代发货订单
	 * @return
	 */
	@Action(value="selOrderDai",results={@Result(name="success",location="/wxht/order.jsp")})
	public String selAllDaiOrder(){
		orders=service.selOrderDai("0");
		 return "success";
	}
	/**
	 * 后台查询所有已发货订单
	 * @return
	 */
	@Action(value="selOrderYi",results={@Result(name="success",location="/wxht/order.jsp")})
	public String selAllOrder(){
		orders=service.selOrderDai("1");
		List<Order> orders2=service.selOrderDai("3");
		for (Order order : orders2) {
			orders.add(order);
		}
		 return "success";
	}
	/**
	 * 取得发货订单兵跳转到物流信息页面
	 */
	@Action(value="fahuo0",results={@Result(name="success",location="/wxht/adress.jsp")})
	public String fahuo0(){
		return "success";
	}
	/**
	 * 发货
	 * @return
	 */
	@Action(value="fahuo",results={@Result(name="success",type="redirect",location="selOrderDai")})
	public String fahuo(){
		Order order1=service.selOrderOne(order.getId());
		order1.setStatus(order.getStatus());
		order1.setCompany(order.getCompany());
		order1.setNum(order.getNum());
		order1.setStatus(1);
		order1.setRemark(order.getRemark());
		service.updateOrder(order1);
		return "success";
	}
	/**
	 * 发货
	 * @return
	 */
	@Action(value="fahuo2",results={@Result(name="success",type="redirect",location="selOrderDai")})
	public String fahuo2(){
		Order order1=service.selOrderOne(order.getId());
		order1.setStatus(order.getStatus());
		order1.setCompany(order.getCompany());
		order1.setNum(order.getNum());
		order1.setStatus(3);
		order1.setRemark(order.getRemark());
		service.updateOrder(order1);
		return "success";
	}
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
