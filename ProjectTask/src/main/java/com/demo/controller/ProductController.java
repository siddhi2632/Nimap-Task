package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	//get all product
	@GetMapping
	private Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,
											@RequestParam(defaultValue = "2") int size)
	{
		Page<Product> products = productService.fetchAllProducts(page, size);
		return  products;
	}
	
	//get product by id
	@GetMapping("/{id}")
	private Product getProductById(@PathVariable("id") int id)
	{
		return productService.getProductById(id);
	}
	
	//save product
	@PostMapping
	private ResponseEntity<Product> saveProduct(@RequestBody Product product)
	{
		productService.saveProduct(product);
		return ResponseEntity.ok(product);
	}
	
	//update product by id
	@PutMapping("/{id}")
	private ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product)
	{
		Product product2 = productService.getProductById(id);
		if(product2!=null)
		{
			product2.setName(product.getName());
			product2.setPrice(product.getPrice());
			product2.setCategory(product.getCategory());
			productService.saveProduct(product2);
			return ResponseEntity.ok(product2);
		}
		return null;
	}
	
	//delete product by id
	@DeleteMapping("/{id}")
	private void deleteproductById(@PathVariable("id") int id)
	{
		productService.deleteProductById(id);
	}
	
}


//insert hoty
