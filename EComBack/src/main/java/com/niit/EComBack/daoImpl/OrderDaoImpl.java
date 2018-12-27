package com.niit.EComBack.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EComBack.dao.OrderDao;

import com.niit.EComBack.model.MyOrder;
@Repository
@Transactional
public class OrderDaoImpl implements OrderDao
{
	@Autowired
    SessionFactory sessionfactory;

	@Override
	public boolean Placeorder(MyOrder order) {
		try 
		{
			sessionfactory.getCurrentSession().save(order);
									return true;
		}
			catch (Exception e) {
				return false;
			}
	}

	@Override
	public List<MyOrder> ViewOrder(int cartid) {
		try {
			return sessionfactory.getCurrentSession().createQuery("from MyOrder where cartid="+cartid).list();
		}

		catch (Exception e) {
			return new ArrayList<MyOrder>();
		}	
	}

	@Override
	public MyOrder Showorder(String orderid) {
		try
		{
			MyOrder order=(MyOrder)sessionfactory.getCurrentSession().createQuery("from MyOrder where orderid='"+orderid+"'").uniqueResult();
		return order;
		}
		catch (Exception e) {
			return null; 		}
	}

	
	
}

	

