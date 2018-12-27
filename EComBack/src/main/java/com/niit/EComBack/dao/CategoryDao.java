package com.niit.EComBack.dao;

import java.util.List;

import com.niit.EComBack.model.Category;

public interface CategoryDao
{
	public boolean addCategory(Category category);	
	public boolean deleteCategory(Category category);	
	public boolean updateCategory(Category category);
	public Category showoneCategory(String categoryName);
	public List<Category> showAllCategory();
}