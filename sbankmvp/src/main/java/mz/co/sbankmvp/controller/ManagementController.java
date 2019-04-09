package mz.co.sbankmvp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mz.co.sbankbackend.dao.CategoryDAO;
import mz.co.sbankbackend.dao.CategoryProprietDAO;
import mz.co.sbankbackend.dao.ProductDAO;
import mz.co.sbankbackend.dao.ProprietDAO;
import mz.co.sbankbackend.entity.Category;
import mz.co.sbankbackend.entity.Categorypropriet;
import mz.co.sbankbackend.entity.Product;
import mz.co.sbankbackend.entity.Propriet;
import mz.co.sbankmvp.util.FileUploadUtility;
import mz.co.sbankmvp.validator.ProductValidator;
import mz.co.sbankmvp.validator.ProprietValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private CategoryProprietDAO categoryproprietDAO;
	
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ProprietDAO proprietDAO;
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products", method=RequestMethod.GET) 
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product nProduct = new Product();
		// set few of the fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);		
		mv.addObject("product", nProduct);
		if(operation!=null) {
			if(operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully!");
			}
			else if(operation.equals("category")) {
				mv.addObject("message", "Category Submitted Successfully!");
			}
		}
		return mv;
	}
	
	
	@RequestMapping(value="/propriets", method=RequestMethod.GET) 
	public ModelAndView showManagePropriets(@RequestParam(name="operation", required=false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManagePropriets", true);
		mv.addObject("title", "Manage Propriets");
		Propriet nProduct = new Propriet();
		// set few of the fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);		
		mv.addObject("propriet", nProduct);
		if(operation!=null) {
			if(operation.equals("propriet")) {
				mv.addObject("message", "Propriet Submitted Successfully!");
			}
			else if(operation.equals("category")) {
				mv.addObject("message", "Category Submitted Successfully!");
			}
		}
		return mv;
	}
	

	@RequestMapping(value="/{id}/product", method=RequestMethod.GET) 
	public ModelAndView showEditProduct(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		// fetch the product from the database
		Product nProduct = productDAO.get(id);
		// set the product fetch from database
		mv.addObject("product", nProduct);

		return mv;
	}	
	
	
	@RequestMapping(value="/{id}/propriet", method=RequestMethod.GET) 
	public ModelAndView showEditPropriet(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManagePropriets", true);
		mv.addObject("title", "Manage Propriets");
		// fetch the product from the database
		Propriet nProduct = proprietDAO.get(id);
		// set the product fetch from database
		mv.addObject("propriet", nProduct);

		return mv;
	}	
	
	
	//handling product submission
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model,
			HttpServletRequest request) {
		
		// handle image validation for new products
		if(mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
		}
		else {
			if(!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, results);
			}
		}
		
		// check if there are any errors
		if(results.hasErrors()) {
				
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for Product Submission!");
						
			return "page";
		}
		
		
		logger.info(mProduct.toString());
		
		
		if(mProduct.getId() == 0) {
			// create a new product record if id is 0
			productDAO.add(mProduct);
		}
		else {
			// update the product if id is not 0
			productDAO.update(mProduct);
		}
		
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}		
	
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	@RequestMapping(value="/propriets", method=RequestMethod.POST)
	public String handleProprietSubmission(@Valid @ModelAttribute("propriet")
	Propriet mProduct, BindingResult results, Model model,
			HttpServletRequest request) {
		
		// handle image validation for new products
		if(mProduct.getId() == 0) {
			new ProprietValidator().validate(mProduct, results);
		}
		else {
			if(!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProprietValidator().validate(mProduct, results);
			}
		}
		
		// check if there are any errors
		if(results.hasErrors()) {
				
			model.addAttribute("userClickManagePropriets", true);
			model.addAttribute("title", "Manage Propriets");
			model.addAttribute("message", "Validation failed for Product Submission!");
						
			return "page";
		}
		
		
		logger.info(mProduct.toString());
		
		
		if(mProduct.getId() == 0) {
			// create a new product record if id is 0
			proprietDAO.add(mProduct);
		}
		else {
			// update the product if id is not 0
			proprietDAO.update(mProduct);
		}
		
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}		
	
		
		return "redirect:/manage/propriets?operation=propriet";
	}
	
	
	@RequestMapping(value = "/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		// is going to fetch the product from the database
		Product product = productDAO.get(id);		
		boolean isActive = product.isActive();
		// activating and deactivating based on the value of active field
		product.setActive(!product.isActive());
		// updating the product
		productDAO.update(product);
				
		return (isActive)? 
				"Desactivou com sucesso " + product.getId() 
				: "Activou com sucesso" + product.getId() ;
	}
	
	

	
	@RequestMapping(value = "/propriet/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProprietActivation(@PathVariable int id) {
		// is going to fetch the product from the database
		Propriet product = proprietDAO.get(id);		
		boolean isActive = product.isActive();
		// activating and deactivating based on the value of active field
		product.setActive(!product.isActive());
		// updating the product
		proprietDAO.update(product);
				
		return (isActive)? 
				"You have succesfully deactivated the propriet with id " + product.getId() 
				: "You have succesfully activated the propriet with id " + product.getId() ;
	}
	
	// to handle category submission
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorypSubmission(@ModelAttribute Category category) {
		// add the new category
		categoryDAO.add(category);
		
		return "redirect:/manage/products?operation=category";
		
	}
	
	@RequestMapping(value="/category/propriets", method=RequestMethod.POST)
	public String handleCategoryProprietSubmission(@ModelAttribute Categorypropriet categorypropriet) {
		// add the new category
		categoryproprietDAO.add(categorypropriet);
		
		return "redirect:/manage/propriets?operation=category";
		
	}
	
	
	// returning categories for all the request mapping 
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}
	

	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	
	@ModelAttribute("categoriesPropriets")
	public List<Categorypropriet> getCategoriesPropriets() {
		return categoryproprietDAO.list();
	}
	

	@ModelAttribute("categoriesPropriet")
	public Categorypropriet getCategorjPropriet() {
		return new Categorypropriet();
	}
	
	
	
}
