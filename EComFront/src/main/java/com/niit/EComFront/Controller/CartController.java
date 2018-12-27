package com.niit.EComFront.Controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.EComBack.dao.CartDao;
import com.niit.EComBack.dao.ProductDao;
import com.niit.EComBack.model.Cart;
import com.niit.EComBack.model.Product;

@Controller
public class CartController
{
	@Autowired
	CartDao cartdao;

	@Autowired
	ProductDao productdao;
	
	@RequestMapping("/addToCart")
	String addToCart(@RequestParam("productName") String productName, HttpSession session, Model m) {
		if (session.getAttribute("usercartid") != null) {
		Product p = productdao.showoneProduct(productName);
				ArrayList<Cart> cartlist = (ArrayList<Cart>) cartdao
					.showAllCart(Integer.parseInt(session.getAttribute("usercartid").toString()));
			Iterator<Cart> cartiterator = cartlist.listIterator();
			while (cartiterator.hasNext()) {
				Cart cart2 = (Cart) cartiterator.next();
				if (cart2.getProductName() == productName) {
					int qty = cart2.getQuantity() + 1;
					if (qty > p.getQuantity()) {
						m.addAttribute("cartpage", true);
						m.addAttribute("title", "GoMiNxt-MyCart");
						m.addAttribute("cartlist", cartdao.showAllCart(cart2.getCartid()));
						m.addAttribute("error1", true);
						m.addAttribute("error", false);
						m.addAttribute("stock", p.getQuantity());
						m.addAttribute("pid", cart2.getPid());
						return "index";

					} else {
						if (qty > 3) {
							m.addAttribute("cartpage", true);
							m.addAttribute("title", "GoMiNxt-MyCart");
							m.addAttribute("cartlist", cartdao.showAllCart(cart2.getCartid()));
							m.addAttribute("error", true);
							m.addAttribute("error1", false);
							m.addAttribute("pid", cart2.getPid());
							return "index";
						}
						cart2.setQuantity(qty);
						cart2.setTotal(qty * p.getPrice());
						cartdao.updateCart(cart2);
						m.addAttribute("cartpage", true);
						m.addAttribute("title", "GoMiNxt-MyCart");
						m.addAttribute("cartlist", cartdao.showAllCart(cart2.getCartid()));
						m.addAttribute("error", false);
						m.addAttribute("error1", false);
						return "index";
					}

				}
			}
			Cart c = new Cart();
			c.setCartid(Integer.parseInt(session.getAttribute("usercartid").toString()));
			c.setPid(p.getProductId());
			c.setQuantity(1);
			c.setProductName(p.getProductName());
			c.setPrice(p.getPrice());
			c.setTotal(p.getPrice());
			cartdao.addCart(c);
			m.addAttribute("cartpage", true);
			m.addAttribute("title", "GoMiNxt-MyCart");
			m.addAttribute("cartlist", cartdao.showAllCart(c.getCartid()));
			m.addAttribute("error", false);
			m.addAttribute("error1", false);
			return "index";

		} else {
			session.setAttribute("proid", productName);
			return "redirect:/Login";
		}

	}

	@RequestMapping("/user/viewCart")
	String viewCart(Model m, HttpSession session) {
		int cartid = Integer.parseInt(session.getAttribute("usercartid").toString());
		m.addAttribute("cartpage", true);
		m.addAttribute("title", "GoMiNxt-MyCart");
		m.addAttribute("cartlist", cartdao.showAllCart(cartid));
		m.addAttribute("error", false);
		m.addAttribute("error1", false);
		return "index";
	}

	@RequestMapping("/user/deleteitem")
	public String deleteCart(@RequestParam("itemid") int id) {
		cartdao.deleteCart(id);
		return "redirect:/user/viewCart";
	}

	@RequestMapping("/user/incqty")
	public String incqty(@RequestParam("itemid") int id, Model m) {
		Cart c = cartdao.showoneCart(id);
		int qty = c.getQuantity() + 1;
		int pqty = productdao.showoneProduct(c.getProductName()).getQuantity();
		if (qty > pqty) {
			m.addAttribute("cartpage", true);
			m.addAttribute("title", "GoMiNxt-MyCart");
			m.addAttribute("cartlist", cartdao.showAllCart(c.getCartid()));
			m.addAttribute("error1", true);
			m.addAttribute("error", false);
			m.addAttribute("stock", pqty);
			m.addAttribute("pid", c.getPid());

			return "index";

		} else {
			if (qty > 3) {
				m.addAttribute("cartpage", true);
				m.addAttribute("title", "GoMiNxt-MyCart");
				m.addAttribute("cartlist", cartdao.showAllCart(c.getCartid()));
				m.addAttribute("error", true);
				m.addAttribute("error1", false);
				m.addAttribute("pid", c.getPid());
				return "index";
			} else {
				c.setQuantity(qty);
				c.setTotal(c.getPrice() * qty);
				cartdao.updateCart(c);
				return "redirect:/user/viewCart";
			}
		}

	}

	@RequestMapping("/user/decqty")
	public String decqty(@RequestParam("itemid") int id, Model m) {
		Cart c = cartdao.showoneCart(id);
		int qty = c.getQuantity() - 1;
		if (qty == 0) {
			m.addAttribute("cartpage", true);
			m.addAttribute("title", "GoMiNxt-MyCart");
			m.addAttribute("cartlist", cartdao.showAllCart(c.getCartid()));
			m.addAttribute("error", true);
			m.addAttribute("pid", c.getPid());
			m.addAttribute("error1", false);
			return "index";
		} else {
			c.setQuantity(qty);
			c.setTotal(c.getPrice() * qty);
			cartdao.updateCart(c);
			return "redirect:/user/viewCart";
		}
	}


}
