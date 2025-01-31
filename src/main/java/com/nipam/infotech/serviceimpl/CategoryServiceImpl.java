package com.nipam.infotech.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nipam.infotech.model.Category;
import com.nipam.infotech.repository.CategoryRepository;
import com.nipam.infotech.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category) {
		
		return categoryRepository.save(category);
	}
	
	@Override
	public List<Category> getAllCategories(long pageNo) {
		Pageable pageable = PageRequest.of((int) pageNo, 2);
		return categoryRepository.findAll(pageable).getContent();
	}

	@Override
	public Category getCategoryById(Long id) {
		
		return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found...!"));
	}
	
	@Override
	public Category updateCategory(Long id, Category category) {
		
		Category existingCategory = getCategoryById(id);
		existingCategory.setName(category.getName());
		existingCategory.setDescription(category.getDescription());
		return categoryRepository.save(existingCategory);
	}

	@Override
	public void deleteCategoryById(Long id) {
		
		categoryRepository.deleteById(id);
	}
	
}
