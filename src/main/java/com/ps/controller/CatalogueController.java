package com.ps.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ps.model.Product;
import com.ps.service.ProductCatalogueService;

@RestController
@RequestMapping("/v1/")
public class CatalogueController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CatalogueController.class);
	
	@Autowired
	ProductCatalogueService productCatalogueService;
	
	@GetMapping(value="/product/all")
	public List<Product> getAllProduct(){
		return productCatalogueService.getAllProduct();
	}
	
	@GetMapping(value="/product")
	public List<Product> searchProduct(@RequestParam Map<String,String> allRequstParam){
		return productCatalogueService.searchProduct(allRequstParam);
	}
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product){
		return productCatalogueService.addProduct(product);
	}
	
	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable("id") long id){
		return productCatalogueService.deleteProduct(id);
	}

}
