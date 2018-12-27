package com.niit.EComBack.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EComBack.dao.CartDao;
import com.niit.EComBack.model.Cart;
import com.niit.EComBack.model.Category;

@Repository
@Transactional
public class CartDaoImpl implements CartDao
{  
	@Autowired
	 SessionFactory sessionfactory;
	@Override
	public boolean addCart(Cart cart) 
	{
		try
		{
			sessionfactory.getCurrentSession().save(cart);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	@Override
	public boolean updateCart(Cart cart) 
	{
		try
		{
			sessionfactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	@Override
	public boolean deleteCart(int id)
	{
		try
		{
			Cart cart=(Cart)sessionfactory.getCurrentSession().createQuery("from Cart where itemid="+id).uniqueResult();
		     sessionfactory.getCurrentSession().delete(cart);
					return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	@Override
	public List<Cart> showAllCart(int id) {
		try {
			return sessionfactory.getCurrentSession()
					.createQuery("from Cart where cartid="+id
							).list();
		}

		catch (Exception e) {
			return new ArrayList<Cart>();
		}	}
	
	@Override
	public Cart showoneCart(int itemid) {

		try
		{
		Cart cart=(Cart)sessionfactory.getCurrentSession().createQuery("from Cart where itemid="+itemid).uniqueResult();
		return cart;
		}
		catch (Exception e)
        {
			return null; 		
			}
	}
	}

	
