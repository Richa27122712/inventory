package com.InventoryManagment.demoInventory.service;

import java.util.List;

import com.InventoryManagment.demoInventory.Entity.Products;


public interface productService {

	Products saveProducts(Products products);

	List<Products> getProducts();
	
	 Products updateProducts(int productId,Products updatedProduct);
	 
	 List<Products> getLowStockProducts(int thrashhold);
	 
	 List<Products> getProductsByName(String productName);
	 
	 List<Products> getPrdoctsWithZeroStock();
}
