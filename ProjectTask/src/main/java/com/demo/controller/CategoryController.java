package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
import com.demo.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	// get all catrgory
	@GetMapping
	private Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "3") int size)
	{
		Page<Category> categories = categoryService.fetchAllCategories(page, size);
        return categories;
	}

	// get category by id
	@GetMapping("/{categoryId}")
	private Category getCategory(@PathVariable("categoryId") int categoryId) {
		return categoryService.getCategoryById(categoryId);
	}

	// delete category by id
	@DeleteMapping("/{categoryId}")
	private void deletecategory(@PathVariable("categoryId") int categoryId) {
		categoryService.deleteCategoryById(categoryId);
	}

	// insert category
	@PostMapping
	private ResponseEntity<Category> savecategory(@RequestBody Category category) {
		categoryService.saveCategory(category);
		return ResponseEntity.ok(category);
	}

	// update category by id
	@PutMapping("/{categoryId}")
	public Category updateCategory(@PathVariable int categoryId, @RequestBody Category category) {
		Category category2 = categoryService.getCategoryById(categoryId);
		if (category2 != null) {
			category2.setCategoryName(category.getCategoryName());
			return categoryService.saveCategory(category2);
		}
		return null;
	}

}
