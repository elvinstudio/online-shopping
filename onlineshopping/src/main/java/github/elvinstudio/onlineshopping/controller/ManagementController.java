package github.elvinstudio.onlineshopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import github.elvinstudio.shoppingbackend.dao.CategoryDAO;
import github.elvinstudio.shoppingbackend.dao.ProductDAO;
import github.elvinstudio.shoppingbackend.dto.Category;
import github.elvinstudio.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger Logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {
		

		ModelAndView mv=new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		Product nProduct = new Product();
		nProduct.setProductSupplier(1);
		nProduct.setProductActive(true);
		mv.addObject("product",nProduct);

		if(operation!=null) {
			if(operation.equals("product")) {
				mv.addObject("message","Product Submitted Successfully!");
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage Products");
			
			return "page";
		}
		
		Logger.info(mProduct.toString());
		
		mProduct.setProductSupplier(1);
		mProduct.setProductActive(true);
		
		productDAO.add(mProduct);
		
		return "redirect:/manage/products?operation=product";
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDAO.list();
	}

}
