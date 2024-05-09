package com.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.model.Category;

public interface CategoryService
{
	//create new Category
	Category saveCategory(Category category);
	
	//get all category
	Page<Category> fetchAllCategories(int page, int size);
	
	
	//get category by id
	Category getCategoryById(int categoryId);
	
	//update category by id
	Category updateCategoryById(int categoryId , Category category);
	
	//string delete category by id
	void deleteCategoryById(int categoryId);
}
