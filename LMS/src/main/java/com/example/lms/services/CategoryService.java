package com.example.lms.services;

import java.util.List;
import com.example.lms.models.Category;

public interface CategoryService {
List<Category> listAllCategories();
Category findCategoryById(Long id);
void createCategory(Category category);
void updateCategory(Category category);
void deleteCategory(Long id);
}
