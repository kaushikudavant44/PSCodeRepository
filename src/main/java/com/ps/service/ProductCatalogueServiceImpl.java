package com.ps.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.ps.constant.ProductCataogue;
import com.ps.model.Product;
import com.ps.repository.ProductCatalogueRepository;

@Service
public class ProductCatalogueServiceImpl implements ProductCatalogueService {
	
	
	@Autowired
	ProductCatalogueRepository productCatalogueRepository;
	
	@Override
	public List<Product> getAllProduct() {
		return productCatalogueRepository.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		if(product !=null)
			return productCatalogueRepository.save(product);
		return new Product();
	}

	@Override
	public List<Product> searchProduct(Map<String, String> allRequstParam) {
		if(!CollectionUtils.isEmpty(allRequstParam)){
			for(Entry<String, String> entry : allRequstParam.entrySet()){
				String param = entry.getKey();
				String val = entry.getValue();
				if(ProductCataogue.PRODUCT_TYPE.equalsIgnoreCase(param) && !StringUtils.isEmpty(val)){
					return productCatalogueRepository.findByProductType(val);
				}
			}
		}
		return null;
	}

	@Override
	public String deleteProduct(long id) {
		try {
		productCatalogueRepository.deleteById(id);
		return ProductCataogue.SUCCESS;
		}catch(Exception e) {
			e.getMessage();
		}		
		return ProductCataogue.FAILED;
	}

}
