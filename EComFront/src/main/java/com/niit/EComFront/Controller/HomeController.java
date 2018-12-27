package com.niit.EComFront.Controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.EComBack.dao.UserDetailDAO;
import com.niit.EComBack.model.UserDetail;

@Controller
public class HomeController
{
   @Autowired
   JavaMailSender jms;
   
   @Autowired
   UserDetailDAO userDetailDAO;

	@RequestMapping(value = "sendmail")
	public String sendmail(HttpServletRequest request) {
		try {
			String recipientAddress = "techgominxt@gmail.com";
			String name = request.getParameter("name");
			String emailId = request.getParameter("e-mail");
			String phoneno = request.getParameter("phone");
			String text = request.getParameter("text");
			String finalmessage = "Hi Admin, " + text + " Contact me in:" + phoneno + "\n\n\n regards\n\n" + name;
			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo(recipientAddress);
			email.setSubject("New Request from"+name);
			email.setText(finalmessage);
			jms.send(email);
			
			String finalmessage1= "Thank you \n\n Regards \n Admin \nGoMiNxt";
			SimpleMailMessage email1=new SimpleMailMessage();
			email1.setTo();
			email1.setSubject(emailId);
			email1.setText(finalmessage1);
			jms.send(email1);
			
		} catch (Exception e) {

		}
		return "redirect:/contactus";
	}

	
	@RequestMapping({"/","/index"})
	public String indexpage(Model M) 
	{
		M.addAttribute("title","GoMiNxt -Home");
		M.addAttribute("carouselpage", true);
		return "index";			
	}
	@RequestMapping(value ="/contactus")
	public String contactus(Model M) 
	{
		M.addAttribute("title","GoMiNxt -Contact");
		M.addAttribute("contactuspage", true);
		return "index";			
	}
	@RequestMapping(value ="/aboutus")
	public String aboutus(Model M) 
	{
		M.addAttribute("title","GoMiNxt -About");
		M.addAttribute("aboutuspage", true);
		return "index";			
	}
	@RequestMapping(value ="/Login")
	public String Login(Model M) 
	{
		M.addAttribute("title","GoMiNxt -Login");
		M.addAttribute("Loginpage", true);
		return "index";			
	}
	
	@RequestMapping({"/flogin"}) 
	public String floginpage(Model m)
	{
		m.addAttribute("floginpage",true);
		m.addAttribute("error", true);
		m.addAttribute("message","User Name & Password incorrect");
		m.addAttribute("title","GoMiNxt-Login");
		return "index";
	}
	
	@RequestMapping("/loginsuccess")
	public String isLoggedin(HttpSession session) 
	{
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) 
		{
			if (authority.getAuthority().equals("ROLE_USER")) 
			{
				UserDetail customer = userDetailDAO.getUserDetail(email);
				session.setAttribute("useremail", customer.getEmailId());
				session.setAttribute("usercartid", customer.getCartId());
				session.setAttribute("username",customer.getUserName());
				session.setAttribute("userlogin", true);
				if(session.getAttribute("proid")!=null)
				{
					return "redirect:/addToCart?pid="+Integer.parseInt(session.getAttribute("proid").toString());
				}
				else
				{
					return "redirect:/";
				}
			} 
			else 
			{
				session.setAttribute("username","Administrator");
				session.setAttribute("userlogin", false);
				return "redirect:/";
			}
		}
		return "redirect:/";
		
	}


			
	}
