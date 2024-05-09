package com.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.repository.ProductRepository;
import com.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductRepository repository;

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return repository.save(product);
	}


	@Override
	public Page<Product> fetchAllProducts(int page, int size) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page, size);
		return repository.findAll(pageable);
	} 
	

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		Optional<Product> optional = repository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	@Override
	public Product updateProductById(int id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}




}
