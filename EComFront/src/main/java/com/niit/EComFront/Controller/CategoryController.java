package com.niit.EComFront.Controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.EComBack.dao.CategoryDao;
import com.niit.EComBack.model.Category;

@Controller
public class CategoryController {
	@Autowired
	CategoryDao CategoryDao;

	@RequestMapping("/admin/category")
	public String categorypage(Model M) {
		M.addAttribute("title","GoMiNxt -Category");
		M.addAttribute("editmode",false);
		Category c = new Category();
		M.addAttribute("category", c);
		M.addAttribute("categorypage", true);
		M.addAttribute("haserror", false);
		M.addAttribute("catlist", CategoryDao.showAllCategory());
		return "index";
	}

	@RequestMapping(value = "/admin/addCategory", method = RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult br, Model M) 
	{
		if (br.hasErrors()) 
		{   M.addAttribute("editmode",false);
		    System.out.println("error");
		    M.addAttribute("title","GoMiNxt -Category");
			M.addAttribute("category", category);
			M.addAttribute("catlist", CategoryDao.showAllCategory());
			M.addAttribute("categorypage", true);
			M.addAttribute("haserror", true);
			M.addAttribute("error", "please check your data");
			return "index";

		} 
		else 
		{
			try 
			{
				M.addAttribute("title","GoMiNxt -Category");
				CategoryDao.addCategory(category);
				return "redirect:/admin/category";
			} 
			catch (Exception e) 
			{   M.addAttribute("editmode",false);
			    M.addAttribute("title","GoMiNxt -Category");
				M.addAttribute("category", category);
				M.addAttribute("catlist", CategoryDao.showAllCategory());
				M.addAttribute("categorypage", true);
				M.addAttribute("haserror", true);
				M.addAttribute("error", "Data Already Present");
				return "index";

			}
		}
	}


	@RequestMapping("/admin/deletecategory")
	public String deleteCategory(@RequestParam("catname")String catname,Model m)
	{
		Category category=CategoryDao.showoneCategory(catname);
		CategoryDao.deleteCategory(category);
		m.addAttribute("title","GoMiNxt -Category");
		return "redirect:/category";
	}
	@RequestMapping("/admin/editcategory")
	public String editCategory(@RequestParam("catname")String catname,Model m)
	{
		m.addAttribute("title","GoMiNxt -Category");
		m.addAttribute("editmode", true);
		m.addAttribute("category",CategoryDao.showoneCategory(catname));		
		m.addAttribute("categorypage", true);
		m.addAttribute("haserror", false);
		m.addAttribute("catlist",CategoryDao.showAllCategory());
		return "index";
	}
	
	@RequestMapping(value = "/admin/updateCategory", method = RequestMethod.POST)
	public String updateCategory(@Valid @ModelAttribute("category") Category category, BindingResult br, Model M) 
	{
		if (br.hasErrors()) 
		{   M.addAttribute("editmode",false);
		    System.out.println("error");
		    M.addAttribute("title","GoMiNxt -Category");
			M.addAttribute("category", category);			
			M.addAttribute("catlist", CategoryDao.showAllCategory());
			M.addAttribute("categorypage", true);
			M.addAttribute("haserror", true);
			M.addAttribute("error", "please check your data");
			return "index";

		} 
		else 
		{
			try 
			{
				CategoryDao.updateCategory(category);
				M.addAttribute("title","GoMiNxt -Category");
				return "redirect:/admin/category";
			} 
			catch (Exception e) 
			{   M.addAttribute("edotmode",false);
			M.addAttribute("title","GoMiNxt -Category");
				M.addAttribute("category", category);			
				M.addAttribute("catlist", CategoryDao.showAllCategory());
				M.addAttribute("categorypage", true);				
				M.addAttribute("haserror", true);
				M.addAttribute("error", "Data Already Present");
				return "index";

			}
		}
	}

	
	
}
