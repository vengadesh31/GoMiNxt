package com.niit.EComFront.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.EComBack.dao.AddressDao;
import com.niit.EComBack.model.Address;

@Controller
public class AddressController 
{
	@Autowired
	AddressDao addressdao;
	@RequestMapping("/user/SelectAddress")
	String ViewAddress(Model m,HttpSession session)
	{
		m.addAttribute("addresspage", true);
		m.addAttribute("address", new Address());
		m.addAttribute("addresslist",addressdao.showallAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
		m.addAttribute("edit",false);
		return "index";
	}
	
	@RequestMapping("/user/editadd")
	String ViewAddress(Model m,HttpSession session,@RequestParam("addid")int id)
	{
		m.addAttribute("addresspage", true);
		m.addAttribute("address", addressdao.showoneAddress(id));
		m.addAttribute("addresslist",addressdao.showallAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
		m.addAttribute("edit",true);
		return "index";
	}
	
	@RequestMapping("/user/deladd")
	String delAddress(Model m,HttpSession session,@RequestParam("addid")int id)
	{
		addressdao.deleteAddress(id);
		return "redirect:/user/SelectAddress";
	}

	@RequestMapping("/user/setaddress")
	String setAddress(@Valid @ModelAttribute("address")Address address,BindingResult br,Model m,HttpSession session)
	{
		if(br.hasErrors())
		{
			m.addAttribute("addresspage", true);
			m.addAttribute("address", address);
			m.addAttribute("addresslist",addressdao.showallAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
			m.addAttribute("edit",false);
		}
		else
		{
			address.setCartid(Integer.parseInt(session.getAttribute("usercartid").toString()));
			addressdao.addAddress(address);
			m.addAttribute("addresspage", true);
			m.addAttribute("address", new Address());
			m.addAttribute("addresslist",addressdao.showallAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
			m.addAttribute("edit",false);
		}
		
		return"index";
		
	}
	
	@RequestMapping("/user/updateaddress")
	String updateAddress(@Valid @ModelAttribute("address")Address address,BindingResult br,Model m,HttpSession session)
	{
		if(br.hasErrors())
		{
			m.addAttribute("addresspage", true);
			m.addAttribute("address", address);
			m.addAttribute("addresslist",addressdao.showallAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
			m.addAttribute("edit",true);
		}
		else
		{
			address.setCartid(Integer.parseInt(session.getAttribute("usercartid").toString()));
			addressdao.updateAddress(address);
			m.addAttribute("addresspage", true);
			m.addAttribute("address", new Address());
			m.addAttribute("addresslist",addressdao.showallAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
			m.addAttribute("edit",false);
		}
		
		return"index";
		
	}
	

}