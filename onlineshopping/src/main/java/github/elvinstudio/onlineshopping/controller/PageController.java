package github.elvinstudio.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import github.elvinstudio.onlineshopping.exception.ProductNotFoundException;
import github.elvinstudio.shoppingbackend.dao.CategoryDAO;
import github.elvinstudio.shoppingbackend.dao.ProductDAO;
import github.elvinstudio.shoppingbackend.dto.Category;
import github.elvinstudio.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside PageController index method - info");
		logger.debug("Inside PageController index method - debug");
		
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("products", productDAO.list(0));
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}

	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("products", productDAO.list(0));
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showAllProducts(@PathVariable("id") int id) {

		Category category = null;

		category = categoryDAO.get(id);
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("products", productDAO.list(id));
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	@RequestMapping(value="show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		
		if(product==null) throw new ProductNotFoundException();
		
		//update the view count
		product.setProductView(product.getProductView()+1);
		productDAO.update(product);
		
		mv.addObject("title", product.getProductName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct",true);
		return mv;
	}
}
