package com.niit.EComBack.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class Category
{  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
	
	
	@Column(nullable=false,unique=true)
	@NotEmpty(message="Category Name is mandatory")
    private String categoryName;
	
	@Column(nullable=false,columnDefinition="text")
	@NotEmpty(message="Category Description is mandatory")
    private String categoryDesc;
	
	
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public String getCategoryDesc() {
	return categoryDesc;
}
public void setCategoryDesc(String categoryDesc) {
	this.categoryDesc = categoryDesc;
}
   
}

