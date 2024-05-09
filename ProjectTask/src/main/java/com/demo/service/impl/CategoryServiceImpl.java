package com.demo.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.model.Category;
import com.demo.repository.CategoryRepository;
import com.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService
{

	@Autowired
	private CategoryRepository repository;
	
	@Override
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		return repository.save(category);
	}
	
	@Override
	 public Page<Category> fetchAllCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }
//	@Override
//	public List<Category> fetchAllCategories() {
//		// TODO Auto-generated method stub
//		List<Category> getAllCategorys= repository.findAll();
//		return getAllCategorys;
//	}

	@Override
	public Category getCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		Optional<Category> optional = repository.findById(categoryId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

	@Override
	public Category updateCategoryById(int categoryId, Category category) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void deleteCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		repository.deleteById(categoryId);
	}

}
