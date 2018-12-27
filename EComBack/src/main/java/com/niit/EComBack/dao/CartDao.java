package com.niit.EComBack.dao;

import java.util.List;

import javax.persistence.Entity;

import com.niit.EComBack.model.Cart;
@Entity
public interface CartDao 
{
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean deleteCart(int id);
	public List<Cart>showAllCart(int cartid);
	public Cart showoneCart(int itemid);

}

