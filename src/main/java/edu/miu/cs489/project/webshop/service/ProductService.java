package edu.miu.cs489.project.webshop.service;

import edu.miu.cs489.project.webshop.model.Product;
import edu.miu.cs489.project.webshop.repository.ProductRepository;
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
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }
    public Product updateProduct(Integer id, Product updatedProduct) {
        Optional<Product> existingProductOptional = productRepository.findById(id);
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
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }




}
