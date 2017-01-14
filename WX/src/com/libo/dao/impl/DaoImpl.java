package com.libo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.libo.dao.Dao;
import com.libo.po.Goods;
import com.libo.po.Order;
@Repository
public class DaoImpl implements Dao {
	@Resource SessionFactory sessionFactory;
	@Override
	public void save(Goods goods) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(goods);
	}
	@Override
	public List<Goods> selAllGoods() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Goods").list();
	}
	@Override
	public void saveOrder(Order order) {
		sessionFactory.getCurrentSession().save(order);
	}
	/**
	 * 通过手机号查订单
	 */
	@Override
	public List<Order> selOrder(String phone) {
		// TODO Auto-generated method stub
		String hql="from Order where phone=:phone";
		 Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("phone", phone);
		return query.list();
	}
	@Override
	public List<Order> selOrderDai(String status) {
		String hql="from Order where status=:status";
		 Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("status", status);
		return query.list();
	}
	@Override
	public void updateOrder(Order order) {
		sessionFactory.getCurrentSession().update(order);
	}
	@Override
	public Order selOrderOne(int orderid) {
		
		return (Order) sessionFactory.getCurrentSession().get(Order.class, orderid);
	}
	@Override
	public List<Goods> selZai(String status) {
		String hql="from Goods where status=:status";
		 Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("status", status);
		return query.list();
	}
	@Override
	public void updateGood(Goods good) {
		sessionFactory.getCurrentSession().update(good);
		
	}
	@Override
	public Goods selGoodsOne(int goodid) {
		return (Goods) sessionFactory.getCurrentSession().get(Goods.class, goodid);
	}
	
}
