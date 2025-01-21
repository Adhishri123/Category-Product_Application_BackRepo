package com.nipam.infotech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.nipam.infotech.model.Product;

public interface ProductService {

//	Product createProduct(Product product);

	Page<Product> getAllProducts(Pageable pageable);

	Product getProductById(Long id);

//	Product updateProduct(Long id, Product product);

	void deleteProduct(Long id);

	Product createProduct(String name, Double price, String description, Long stock, Long categoryId,
			MultipartFile image);

	Product updateProduct(Long id, String name, Double price, String description, Long stock, Long categoryId,
			MultipartFile image);

}
