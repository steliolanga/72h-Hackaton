package mz.co.sbankmvp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mz.co.sbankbackend.dao.ProductDAO;
import mz.co.sbankbackend.dao.ProprietDAO;
import mz.co.sbankbackend.entity.Product;
import mz.co.sbankbackend.entity.Propriet;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ProprietDAO proprietDAO;
	
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		
		return productDAO.listActiveProducts();
				
	}
	@RequestMapping("/all/propriets")
	@ResponseBody
	public List<Propriet> getAllPropriets() {
		return proprietDAO.listActivePropriets();			
	}
	
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsForAdmin() {
		
		return productDAO.list();
				
	}	
	
	
	@RequestMapping("/admin/all/propriets")
	@ResponseBody
	public List<Propriet> getAllProprietsForAdmin() {
		
		return proprietDAO.list();
				
	}	
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id) {
		
		return productDAO.listActiveProductsByCategory(id);
				
	}
	
	@RequestMapping("/category/{id}/propriets")
	@ResponseBody
	public List<Propriet> getProprietsByCategory(@PathVariable int id) {
		
		return proprietDAO.listActiveProprietByCategory(id);
				
	}
	
	
	
}
