package com.ps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ps.model.Product;

public interface ProductCatalogueRepository extends JpaRepository<Product, Long>{
	
	List<Product> findByProductType(@Param("productType") String productType);
	
	@Modifying
    @Transactional
    @Query("delete from Product products where products.id = :id ")
    void deleteById(@Param("id") Long id);

}
