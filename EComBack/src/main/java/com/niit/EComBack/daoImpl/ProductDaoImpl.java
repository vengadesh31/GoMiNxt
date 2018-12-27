package com.niit.EComBack.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.EComBack.dao.ProductDao;
import com.niit.EComBack.model.Category;
import com.niit.EComBack.model.Product;
@Repository("ProductDao")
@Transactional
public class ProductDaoImpl implements ProductDao
{
	@Autowired
	
	SessionFactory sessionfactory;
	public boolean addProduct(Product product)
	{
		try
		{
			sessionfactory.getCurrentSession().save(product);
			return true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteProduct(Product product) 
	{
		try
		{
			sessionfactory.getCurrentSession().delete(product);
			return true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Product showoneProduct(String productName)
	{
		try
		{
			return(Product)sessionfactory.getCurrentSession().createQuery("from Product where productName='"+productName+"'").uniqueResult();
		}
		catch (Exception e)
		{
     		return null;
		}
	}

	public List<Product> showallProduct()
	{
		try
		{    
			return sessionfactory.getCurrentSession().createQuery("from Product").list();
			
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	public boolean updateProduct(Product product) 
	{
		try
		{
			sessionfactory.getCurrentSession().update(product);
			return true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
}
	
	

