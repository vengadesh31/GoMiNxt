package com.niit.EComBack.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EComBack.dao.AddressDao;
import com.niit.EComBack.model.Address;
import com.niit.EComBack.model.Category;

@Repository
@Transactional
public class AddressDaoImpl implements AddressDao
{
	@Autowired
    SessionFactory sessionfactory;

	@Override
	public boolean addAddress(Address address)
	{
		try 
		{
			sessionfactory.getCurrentSession().save(address);
			return true;
		 } 
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public boolean deleteAddress(int id)
	{
		try 
		{
			sessionfactory.getCurrentSession().delete(showoneAddress(id));
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateAddress(Address address) 
	{
		try {
			sessionfactory.getCurrentSession().update(address);
			return true;

		}
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public List<Address> showallAddress(int cartid)
	{
		try {
			return sessionfactory.getCurrentSession().createQuery("from Address where cartid=" + cartid).list();
		}

		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			return null;

		}
	}

	@Override
	public Address showoneAddress(int addressid) {
		try {
			System.out.println("2");
			return (Address) sessionfactory.getCurrentSession().createQuery("from Address where addressid=" + addressid)
					.uniqueResult();
		}

		catch (Exception e) {
			return null;

		}
	}
	

}
