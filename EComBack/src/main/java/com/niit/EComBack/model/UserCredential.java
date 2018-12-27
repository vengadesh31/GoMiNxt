package com.niit.EComBack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class UserCredential
{
	String password;

    @Id
    String emailId;
    String role;
    public String getPassword() {
            return password;
    }
    public void setPassword(String password) {
            this.password = password;
    }
    public String getEmailId() {
            return emailId;
    }
    public void setEmailId(String emailId) {
            this.emailId = emailId;
    }
    public String getRole() {
            return role;
    }
    public void setRole(String role) {
            this.role = role;
    }

}
