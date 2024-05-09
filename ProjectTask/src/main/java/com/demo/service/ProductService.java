package com.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.model.Product;

public interface ProductService 
{
	//create new Category
		Product saveProduct(Product product);
		
		//get all product
		Page<Product> fetchAllProducts(int page, int size);
		
		//get product by id
		Product getProductById(int id);
		
		//update product by id
		Product updateProductById(int id , Product product);
		
		//string delete product by id
		void deleteProductById(int id);
}
