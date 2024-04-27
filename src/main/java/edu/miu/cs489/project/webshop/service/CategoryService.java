package edu.miu.cs489.project.webshop.service;

import edu.miu.cs489.project.webshop.dto.UpdateCategoryDTORequest;
import edu.miu.cs489.project.webshop.model.Category;
import edu.miu.cs489.project.webshop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public Category addNewCategory(Category category) {
        return categoryRepository.save(category);
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public Category getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with productId: " + categoryId));
    }

    public Category updateCategory(Integer categoryId, UpdateCategoryDTORequest updatedCategory) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            Category existingCategory = optionalCategory.get();
            existingCategory.setName(updatedCategory.name());
            return categoryRepository.save(existingCategory);
        } else {
            throw new IllegalArgumentException("Category not found with id: " + categoryId);
        }
    }

    public void deleteCategory(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

}
