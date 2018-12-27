package com.niit.EComBack.daoImpl;



import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.EComBack.dao.UserDetailDAO;

import com.niit.EComBack.model.UserCredential;
import com.niit.EComBack.model.UserDetail;
@Repository("userDetailDAO")
@Transactional

public class UserDetailDAOImp implements UserDetailDAO{
        @Autowired
        SessionFactory sessionFactory;
        
        public boolean adduser(UserDetail userDetail) 
        {
                try
                {
                UserCredential uc=new UserCredential();
                uc.setEmailId(userDetail.getEmailId());
                uc.setPassword(userDetail.getPassword());
                uc.setRole("ROLE_USER");

                sessionFactory.getCurrentSession().saveOrUpdate(userDetail);
                sessionFactory.getCurrentSession().saveOrUpdate(uc);

                return true;
                }
                catch(Exception e)
                {
                return false;
                }
        }

        public UserDetail getUserDetail(String emailId) {
                try
                {
                Session session=sessionFactory.openSession();
                UserDetail c=(UserDetail)session.createCriteria(UserDetail.class).add(Restrictions.eq("emailId",emailId)).uniqueResult();
                session.close();
                return c;
                }
                catch (Exception e)
                {
                        
                        return null;
                               
                }
            }
        }