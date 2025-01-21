package com.nipam.infotech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.nipam.infotech.model.Category;

public interface CategoryService {

	Category saveCategory(Category category);

	Page<Category> getAllCategories(Pageable pageable);

	Category getCategoryById(Long id);

	void deleteCategoryById(Long id);

	Category updateCategory(Long id, Category category);

}
