package com.libo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.libo.dao.Dao;
import com.libo.po.Goods;
import com.libo.po.Order;
import com.libo.service.Service;
@org.springframework.stereotype.Service
@Transactional
public class ServiceImpl implements Service {
	@Resource Dao dao;
	@Override
	public void save(Goods goods) {
		dao.save(goods);
	}
	@Override
	public List<Goods> selAllGoods() {
		return dao.selAllGoods();
	}
	@Override
	public void saveOrder(Order order) {
		dao.saveOrder(order);
	}
	@Override
	public List<Order> selOrder(String phone) {
		return dao.selOrder(phone);
	}
	@Override
	public List<Order> selOrderDai(String status) {
		return dao.selOrderDai(status);
	}
	@Override
	public void updateOrder(Order order) {
		dao.updateOrder(order);
		
	}
	@Override
	public Order selOrderOne(int orderid) {
		return dao.selOrderOne(orderid);
	}
	@Override
	public List<Goods> selZai(String status) {
		return dao.selZai(status);
	}
	@Override
	public void updateGood(Goods good) {
		dao.updateGood(good);
		
	}
	@Override
	public Goods selGoodsOne(int goodid) {
	
		return dao.selGoodsOne(goodid);
	}

}
