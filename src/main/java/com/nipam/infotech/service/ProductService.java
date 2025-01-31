package com.nipam.infotech.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import com.nipam.infotech.model.Product;

public interface ProductService {
	
	Product createProduct(String name, Double price, String description, Long stock, Long categoryId,
			MultipartFile image);
	
	List<Product> getAllProducts(long pageNo);

	Product getProductById(Long id);

	void deleteProduct(Long id);

	Product updateProduct(Long id, String name, Double price, String description, Long stock, Long categoryId,
			MultipartFile image);

}
