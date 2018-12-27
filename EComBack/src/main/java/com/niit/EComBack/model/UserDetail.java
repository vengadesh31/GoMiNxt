package com.niit.EComBack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
@Entity 
public class UserDetail {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
int cartId;

@Column(nullable=false)
@NotEmpty(message="Name cannot be blank")
String userName;

@Transient
@Column(nullable = false)
@NotEmpty(message="Please enter the password")
@Pattern(regexp="[a-zA-Z0-9]{8,12}",message="Password must contain atleast one capital letter,one small letter and one number 8-12 values")
String password;

@Column(unique=true,nullable=false)
@NotEmpty(message="Mobile number shouldn't be blank")
@Pattern(regexp="[9876][0-9]{9}",message="Please give valid mobile  number")
String mobileNo;

public int getCartId() {
        return cartId;
}
public void setCartId(int cartId) {
        this.cartId = cartId;
}
@Column(nullable=false,unique=true)
@NotEmpty(message="Email Id cannot blank")
@Email(regexp="[a-z0-9_.$]+@[a-z]+\\.[a-z]{2,3}",message="please ent the valid Email id")

String emailId;

public String getUserName() {
        return userName;
}
public void setUserName(String userName) {
        this.userName = userName;
}
public String getPassword() {
        return password;
}
public void setPassword(String password) {
        this.password = password;
}
public String getMobileNo() {
        return mobileNo;
}
public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
}
public String getEmailId() {
        return emailId;
}
public void setEmailId(String emailId) {
        this.emailId = emailId;
}
}