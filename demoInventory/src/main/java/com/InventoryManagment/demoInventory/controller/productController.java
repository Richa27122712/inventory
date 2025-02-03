package com.InventoryManagment.demoInventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.InventoryManagment.demoInventory.Entity.Products;
import com.InventoryManagment.demoInventory.service.productService;

@RestController
@RequestMapping("/inventory")
public class productController {

	@Autowired
	private productService productservice;
	
	
	@PostMapping("/add")
	public ResponseEntity<Products> saveAllProducts( @RequestBody Products products){
	Products product=	productservice.saveProducts(products);
		
		return new ResponseEntity<>(product,HttpStatus.CREATED);
	}
	
	 @GetMapping("/allproducts") 
	 public ResponseEntity<List<Products>> getAllProducts(){
		List<Products> product= productservice.getProducts();
		return new ResponseEntity<>(product,HttpStatus.OK);
	 }
	 
	 @PutMapping("/update/{productId}")
	 public ResponseEntity<Products> updateProducts(@PathVariable int productId,@RequestBody Products products){
		 Products product=	productservice.updateProducts(productId, products);
		 return new ResponseEntity<>(product,HttpStatus.CREATED);
	 }
	 
	 @GetMapping("/thrashold")
	 public ResponseEntity<List<Products>> getLowStockProducts(@RequestParam int thrashold){
		 List<Products> product=productservice.getLowStockProducts(thrashold);
		 return new ResponseEntity<>(product,HttpStatus.OK);	
		 }
	 
	 @GetMapping("/productbyname")
	 public ResponseEntity<List<Products>> getProductsByName(@RequestParam String productName){
		 List<Products> product =productservice.getProductsByName(productName);
		 return new ResponseEntity<>(product,HttpStatus.OK);
	 }
	 
	 @GetMapping("/zeroStock")
	 public ResponseEntity<List<Products>> getZeroStockProducts(){
		 List<Products> products=productservice.getPrdoctsWithZeroStock();
		 return new ResponseEntity<>(products,HttpStatus.OK);
	 }
	 
}
