package com.InventoryManagment.demoInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.InventoryManagment.demoInventory.Entity.Products;

public interface ProductRepository extends JpaRepository<Products,Integer> {

	List<Products> findByStockQuantityLessThan(int thrashhold);

	List<Products> findByProductName(String productName);

}
