package edu.miu.cs489.project.webshop.service;

import edu.miu.cs489.project.webshop.model.Product;
import edu.miu.cs489.project.webshop.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProductById(Integer productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with productId: " + productId));
    }
    public Product updateProduct(Integer productId, Product updatedProduct) {
        Optional<Product> existingProductOptional = productRepository.findById(productId);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setOwner(updatedProduct.getOwner());
            existingProduct.setOriginCountry(updatedProduct.getOriginCountry());
            existingProduct.setAvailableQuantity(updatedProduct.getAvailableQuantity());
            existingProduct.setPrice(updatedProduct.getPrice());
            return productRepository.save(existingProduct);
        }
        return null;
    }
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }




}
