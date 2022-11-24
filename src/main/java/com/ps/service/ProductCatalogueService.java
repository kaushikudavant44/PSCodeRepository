package com.ps.service;

import java.util.List;
import java.util.Map;

import com.ps.model.Product;

public interface ProductCatalogueService {

	List<Product> getAllProduct();

	Product addProduct(Product product);

	List<Product> searchProduct(Map<String, String> allRequstParam);

	String deleteProduct(long id);

}