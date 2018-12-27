package com.niit.EComBack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Address
{
	@Id
	@GeneratedValue
	private int addressid;

	@Column(nullable = false)
	private int cartid;
	
	@Column(nullable = false)
	@NotBlank(message = "Name is mandatory")
	private String name;

	@Column(nullable = false)
	@NotBlank(message = "Address line 1 is mandatory")
	private String addline1;

	@Column(nullable = false)
	@NotBlank(message = "Address line 2 is mandatory")
	private String addline2;

	@Column(nullable = false)
	@NotBlank(message = "City name is mandatory")
	private String city;

	@Column(nullable = false)
	@NotBlank(message = "State name is mandatory")
	private String state;

	@Column(nullable = false)
	@NotBlank(message = "Country is mandatory")
	private String country;

	@NotBlank(message = "pincode is mandatory")
	private String pincode;

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddline1() {
		return addline1;
	}

	public void setAddline1(String addline1) {
		this.addline1 = addline1;
	}

	public String getAddline2() {
		return addline2;
	}

	public void setAddline2(String addline2) {
		this.addline2 = addline2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	
	
	
}
