package com.niit.EComBack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table
	public class Product
	{
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private int productId;
	   
	   @Column(nullable=false,unique=true)
	   @NotEmpty(message="Product Name is mandatory")
	   private String productName;
	   
	   @Column(nullable=false,columnDefinition="text")
	   @NotEmpty(message="Product Description is mandatory")
	   private String productDesc;
	   
	   @Column(nullable = false)
	   @Min(value=1, message= "quantity must be greater than 0")
	   private int quantity;
	   
	   @Column(nullable = false)
	   @Min(value=1, message= "price must be greater than 0 ")
	   private float price;
	   
	   @ManyToOne
	   @OnDelete(action = OnDeleteAction.CASCADE)
	   private Category category;
	   
	   @Transient
	   MultipartFile pimage;
	   
	   
	   

	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}	
	   }
	   
	   
