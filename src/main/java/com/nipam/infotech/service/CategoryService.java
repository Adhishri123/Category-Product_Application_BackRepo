package com.nipam.infotech.service;

import java.util.List;

import com.nipam.infotech.model.Category;

public interface CategoryService {

	Category saveCategory(Category category);

	List<Category> getAllCategories(long pageNo);

	Category getCategoryById(Long id);

	void deleteCategoryById(Long id);

	Category updateCategory(Long id, Category category);

}
