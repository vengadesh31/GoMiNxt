package com.niit.EComBack.dao;

import java.util.List;

import javax.persistence.Entity;

import com.niit.EComBack.model.Address;

@Entity
public interface AddressDao
{
    public boolean addAddress(Address address);
    public boolean deleteAddress(int id);
    public boolean updateAddress(Address address);
    public List<Address>showallAddress(int cartid);
	public Address showoneAddress(int addressid);
	
}
