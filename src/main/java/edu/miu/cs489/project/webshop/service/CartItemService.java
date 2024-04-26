package edu.miu.cs489.project.webshop.service;

import edu.miu.cs489.project.webshop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    private CategoryRepository categoryRepository;
    public CartItemService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
