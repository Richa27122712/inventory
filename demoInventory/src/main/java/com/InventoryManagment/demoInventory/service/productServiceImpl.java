package com.InventoryManagment.demoInventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.InventoryManagment.demoInventory.Entity.Products;
import com.InventoryManagment.demoInventory.Repository.ProductRepository;

@Service
public class productServiceImpl implements productService {

	@Autowired
	private ProductRepository productRepository;
	
	public Products saveProducts( Products products) {
		return productRepository.save(products);
	}
	  
	public List<Products> getProducts(){
		return productRepository.findAll();
	}
	
	public Products updateProducts(int productId,Products updatedProduct) {
		Products exitingProducts =productRepository.findById(productId).orElseThrow(()-> new RuntimeException(" Products not found"));
		
		exitingProducts.setProductName(updatedProduct.getProductName());
		return productRepository.save(exitingProducts);
	}

	public List<Products> getLowStockProducts(int thrashhold){
		return productRepository.findByStockQuantityLessThan(thrashhold);
	}
	
	public List<Products> getProductsByName(String productName){
		return productRepository.findByProductName(productName);
	}
	public List<Products> getPrdoctsWithZeroStock(){
		return productRepository.findByStockQuantityLessThan(1);
	}

}
