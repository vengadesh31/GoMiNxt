package com.niit.EComBack.dao;

import com.niit.EComBack.model.UserDetail;
public interface UserDetailDAO {
        public boolean adduser(UserDetail userDetail);
        public UserDetail getUserDetail(String emailId);
}
