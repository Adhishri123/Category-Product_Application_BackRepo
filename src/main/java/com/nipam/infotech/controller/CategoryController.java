package com.nipam.infotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nipam.infotech.model.Category;
import com.nipam.infotech.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping
	public Category addCategory(@RequestBody Category category) {
		return categoryService.saveCategory(category);
	}
	
	@GetMapping
	public List<Category> getAllCategory(@RequestParam("page") long pageNo) {
		List<Category> list =  categoryService.getAllCategories(pageNo);
		return list;
	}
	
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}
	
	@PutMapping("/{id}") 
	public Category editCategory(@PathVariable Long id,@RequestBody Category category) {
		return categoryService.updateCategory(id, category);
	}
	
	@DeleteMapping("/{id}") 
	public void removeCategoryById(@PathVariable Long id) {
		categoryService.deleteCategoryById(id);
	}
	
}
