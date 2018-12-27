package com.niit.EComFront.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.EComBack.dao.AddressDao;
import com.niit.EComBack.dao.CartDao;
import com.niit.EComBack.dao.OrderDao;
import com.niit.EComBack.dao.ProductDao;
import com.niit.EComBack.model.Cart;
import com.niit.EComBack.model.MyOrder;
import com.niit.EComBack.model.Product;

@Controller
public class OrderController
{
    @Autowired
	CartDao cartdao;
    
    @Autowired
    OrderDao orderdao;
    
    @Autowired
    AddressDao addressdao;
    
    @Autowired
    ProductDao productdao;
    
    @RequestMapping("/user/placeorder")
	String placeOrder(@RequestParam("addid")int id,HttpSession session)
	{
		ArrayList<Cart> cartlist = (ArrayList<Cart>) cartdao
				.showAllCart(Integer.parseInt(session.getAttribute("usercartid").toString()));
		Iterator<Cart> cartiterator = cartlist.listIterator();
		while (cartiterator.hasNext())
		{
			Cart cart2 = (Cart) cartiterator.next();
			Long uuid=UUID.randomUUID().getMostSignificantBits();
			String oid="OD"+uuid.toString().replace('-', '2');
			MyOrder order=new MyOrder();
			Product p=productdao.showoneProduct(cart2.getProductName());
			int qty=p.getQuantity()-cart2.getQuantity();
			System.out.println(qty);
			p.setQuantity(qty);
			productdao.updateProduct(p);
			order.setOrderid(oid);
			order.setCartid(Integer.parseInt(session.getAttribute("usercartid").toString()));
			order.setAddid(id);
			order.setOdate(new Date());
			order.setPid(cart2.getPid());
			order.setProduct_Name(cart2.getProductName());
			order.setQuantity(cart2.getQuantity());
			order.setPrice(cart2.getTotal());
			orderdao.Placeorder(order);
			cartdao.deleteCart(cart2.getItemid());
		}
		return "redirect:/user/viewOrders";
	}
	
	@RequestMapping("/user/viewOrders")
	String viewOrders(Model m,HttpSession session)
	{
		m.addAttribute("orderlist",orderdao.ViewOrder(Integer.parseInt(session.getAttribute("usercartid").toString())));
		m.addAttribute("orderpage",true);
		return"index";
		
	}
	
	@RequestMapping("/user/viewbill")
	String viewBills(Model m,HttpSession session,@RequestParam("orderid")String id)
	{
		MyOrder o=orderdao.Showorder(id);
		m.addAttribute("order",o);
		m.addAttribute("address",addressdao.showoneAddress(o.getAddid()));
		m.addAttribute("billpage",true);
		return"index";
		
	}
	
    
}
