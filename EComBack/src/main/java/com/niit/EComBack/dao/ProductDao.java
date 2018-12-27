package com.niit.EComBack.dao;

import java.util.List;

import com.niit.EComBack.model.Product;

public interface ProductDao 
{
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public List<Product> showallProduct();
	public Product showoneProduct(String productName);
}
