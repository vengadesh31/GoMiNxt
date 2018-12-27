package com.niit.EComFront.Controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.EComBack.dao.CategoryDao;
import com.niit.EComBack.dao.ProductDao;
import com.niit.EComBack.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDao ProductDao;
	
	@Autowired
	CategoryDao CategoryDao;

	void addimage(MultipartFile f, int id) {
		try {
			String path = "E:\\vignesh project\\EComFront\\src\\main\\webapp\\resources\\productimage\\";//location that u copied
			path = path + String.valueOf(id) + ".jpg";
			if (!f.isEmpty()) {
				byte[] imagebytes = f.getBytes();
				File x = new File(path);
				if (x.exists()) {
					x.delete();
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				} else {
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				}
			}
			Thread.sleep(5000);
		} catch (Exception e) {

		}	}	
	
	@RequestMapping("/admin/product")
	public String productpage(Model M)
	{
		M.addAttribute("title","GoMiNxt -Product");
		M.addAttribute("editmode",false);
		M.addAttribute("productpage", true);
		M.addAttribute("product", new Product());
		M.addAttribute("prodlist",ProductDao.showallProduct());
		M.addAttribute("catlist", CategoryDao.showAllCategory());
		M.addAttribute("haserror", false);
		M.addAttribute("error","");
		return "index";
	}

	@RequestMapping(value = "/admin/addProduct", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult br, Model M) 
	{
		if (br.hasErrors()) 
		{ 
			M.addAttribute("title","GoMiNxt -Product");
			M.addAttribute("editmode",false);
		    System.out.println("error");
			M.addAttribute("product", product);
			M.addAttribute("prodlist", ProductDao.showallProduct());
			M.addAttribute("catlist", CategoryDao.showAllCategory());
			M.addAttribute("productpage", true);
			M.addAttribute("haserror", true);
			M.addAttribute("error", "please check your data");
			return "index";

		} 
		else 
		{
			try 
			{
				M.addAttribute("title","GoMiNxt -Product");
				System.out.println("running");
				ProductDao.addProduct(product);
				addimage(product.getPimage(), product.getProductId());
				return "redirect:/admin/product";
			} 
			catch (Exception e)
			{  
				M.addAttribute("title","GoMiNxt -Product");
				System.out.println(e.getMessage());
				M.addAttribute("editmode",false);
			    M.addAttribute("productpage", true);
				M.addAttribute("product", product);
				M.addAttribute("prodlist", ProductDao.showallProduct());
				M.addAttribute("catlist", CategoryDao.showAllCategory());
				M.addAttribute("haserror", true);
				M.addAttribute("error", "Data Already Present");
				return "index";

			}
		}
	}


	@RequestMapping("/admin/deleteProduct")
	public String deleteProduct(@RequestParam("productName")String productName,Model M)
	{
		M.addAttribute("title","GoMiNxt -Product");
		Product product=ProductDao.showoneProduct(productName);
		ProductDao.deleteProduct(product);		
		return "redirect:/admin/product";
	}
	@RequestMapping("/admin/editProduct")
	public String editProduct(@RequestParam("productName")String productId,Model M)
	{
		M.addAttribute("title","GoMiNxt -Product");
		M.addAttribute("editmode", true);
		System.out.println("running successful");
		M.addAttribute("product",ProductDao.showoneProduct(productId));		
		M.addAttribute("productpage", true);
		M.addAttribute("haserror", false);
		M.addAttribute("prodlist",ProductDao.showallProduct());
		M.addAttribute("catlist",CategoryDao.showAllCategory());
		return "index";
	}
	
	@RequestMapping(value = "/admin/updateProduct", method = RequestMethod.POST)
	public String updateProduct(@Valid @ModelAttribute("product") Product product, BindingResult br, Model M) 
	{
		if (br.hasErrors()) 
		{  
			M.addAttribute("title","GoMiNxt -Product");
			M.addAttribute("editmode",false);
		    System.out.println("error");
			M.addAttribute("product", product);			
			M.addAttribute("prodlist", ProductDao.showallProduct());
			M.addAttribute("productpage", true);
			M.addAttribute("haserror", true);
			M.addAttribute("catlist", CategoryDao.showAllCategory());
			M.addAttribute("error", "please check your data");
			return "index";

		} 
		else 
		{
			try 
			{
				M.addAttribute("title","GoMiNxt -Product");
				ProductDao.updateProduct(product);
				addimage(product.getPimage(), product.getProductId());
				return "redirect:/admin/product";
			} 
			catch (Exception e) 
			{
				M.addAttribute("title","GoMiNxt -Product");
				M.addAttribute("editmode",false);
				M.addAttribute("product", product);			
				M.addAttribute("prodlist", ProductDao.showallProduct());
				M.addAttribute("productpage", true);				
				M.addAttribute("haserror", true);
				M.addAttribute("catlist",CategoryDao.showAllCategory());
				M.addAttribute("error", "Data Already Present");
				return "index";

			}
		}
	}
	 
	@RequestMapping("/viewallProduct")
	public String viewallProduct(Model M)
	{
		M.addAttribute("title","GoMiNxt -Product");
		M.addAttribute("prodlist",ProductDao.showallProduct());
		M.addAttribute("viewallProduct",true);
		return "index";
	}
	
	@RequestMapping("/viewoneProduct")
	public String viewoneProduct(@RequestParam("productname")String productname, Model M)
	{
		M.addAttribute("title","GoMiNxt -Product");
		M.addAttribute("p",ProductDao.showoneProduct(productname));
		M.addAttribute("viewoneProduct",true);
		return "index";
	}
	
	
	
	
}
