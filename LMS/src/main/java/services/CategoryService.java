package services;

import java.util.List;
import models.Category;

public interface CategoryService {
List<Category> listAllCategories();
Category findCategoryById(Long id);
void createCategory(Category category);
void updateCategory(Category category);
void deleteCategory(Long id);
}
