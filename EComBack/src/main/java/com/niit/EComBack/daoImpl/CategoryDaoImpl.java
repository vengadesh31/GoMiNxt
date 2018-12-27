package com.niit.EComBack.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.EComBack.dao.CategoryDao;
import com.niit.EComBack.model.Category;


@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao 
{   
	@Autowired
     SessionFactory sessionfactory;
	public boolean addCategory(Category category) 
	{
		try
		{
			sessionfactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteCategory(Category category) 
	{
		try
		{
			sessionfactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateCategory(Category category)
	{
		try
		{
			sessionfactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Category showoneCategory(String categoryName) 
	{
		try
		{
			return(Category)sessionfactory.getCurrentSession().createQuery("from Category where categoryName='"+categoryName+"'").uniqueResult();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<Category> showAllCategory() 
	{
		try
		{
		return sessionfactory.getCurrentSession().createQuery("from Category").list();
	    }
		catch(Exception e)
		{
		return null;	
		}
	}
}

