package com.nipam.infotech.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nipam.infotech.model.Category;
import com.nipam.infotech.model.Product;
import com.nipam.infotech.repository.CategoryRepository;
import com.nipam.infotech.repository.ProductRepository;
import com.nipam.infotech.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Product createProduct(String name, Double price, String description, Long stock, Long categoryId,
			MultipartFile image) {
		Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setStock(stock);
        product.setCategory(category);

        if (image != null && !image.isEmpty()) {
            try {
                product.setImage(image.getBytes());
            } catch (IOException e) {
                throw new RuntimeException("Error processing the image file", e);
            }
        }

        return productRepository.save(product);
	}
	
	@Override
	public List<Product> getAllProducts(long pageNo) {
		Pageable pageable = PageRequest.of((int) pageNo, 2);
		return productRepository.findAll(pageable).getContent();
	}

	@Override
	public Product getProductById(Long id) {
		
		return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found...!"));
	}
	
	@Override
	public Product updateProduct(Long id, String name, Double price, String description, Long stock, Long categoryId,
			MultipartFile image) {
		Product existingProduct = getProductById(id);

        existingProduct.setName(name);
        existingProduct.setPrice(price);
        existingProduct.setDescription(description);
        existingProduct.setStock(stock);

        if (categoryId != null) {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            existingProduct.setCategory(category);
        }

        if (image != null && !image.isEmpty()) {
            try {
                existingProduct.setImage(image.getBytes());
            } catch (IOException e) {
                throw new RuntimeException("Error processing the image file", e);
            }
        }

        return productRepository.save(existingProduct);
	}

	@Override
	public void deleteProduct(Long id) {
		
		productRepository.deleteById(id);
	}
}
