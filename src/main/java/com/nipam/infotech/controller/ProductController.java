package com.nipam.infotech.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.nipam.infotech.model.Product;
import com.nipam.infotech.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping(consumes = {"multipart/form-data"})
	public Product createProduct(
	        @RequestParam("name") String name,
	        @RequestParam("price") Double price,
	        @RequestParam("description") String description,
	        @RequestParam("stock") Long stock,
	        @RequestParam("categoryId") Long categoryId,
	        @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {

		return productService.createProduct(name, price, description, stock, categoryId, image);
	}
	
	@GetMapping
    public List<Product> getAllProducts(@RequestParam("page") long pageNo) {
		List<Product> list = productService.getAllProducts(pageNo);
         return list;
    }
	
	@GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("price") Double price,
            @RequestParam("description") String description,
            @RequestParam("stock") Long stock,
            @RequestParam("categoryId") Long categoryId,
            @RequestParam(value = "image", required = false) MultipartFile image) {
    	return productService.updateProduct(id, name, price, description, stock, categoryId, image);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
