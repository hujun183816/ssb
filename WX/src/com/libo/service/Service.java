package com.libo.service;

import java.util.List;

import com.libo.po.Goods;
import com.libo.po.Order;

public interface Service {
	public void save(Goods goods);
	public List<Goods> selAllGoods();
	public void saveOrder(Order order) ;
	public List<Order> selOrder(String phone);
	/**
	 * 查询代发货订单
	 * @param status
	 * @return
	 */
	public List<Order> selOrderDai(String status);
	/**
	 * 更新订单
	 */
	public void updateOrder(Order order);
	public Order selOrderOne(int orderid);
	public List<Goods> selZai(String status);
	public void updateGood(Goods good) ;
	public Goods selGoodsOne(int goodid);
}
