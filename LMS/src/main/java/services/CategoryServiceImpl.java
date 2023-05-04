package services;

import java.util.List;
import java.util.Optional;
import models.Category;
import org.springframework.stereotype.Service;
import repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
private final CategoryRepository categoryRepository;
public CategoryServiceImpl(CategoryRepository categoryRepository){
  this.categoryRepository = categoryRepository;
}

  @Override
  public List<Category> listAllCategories() {
    return categoryRepository.findAll();
  }

  @Override
  public Category findCategoryById(Long id) {
    return categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
  }

  @Override
  public void createCategory(Category category) {
  categoryRepository.save(category);
  }

  @Override
  public void updateCategory(Category category) {
  categoryRepository.save(category);
  }

  @Override
  public void deleteCategory(Long id) {
    Optional<Category> category = categoryRepository.findById(id);
    if(category.isPresent()){
      categoryRepository.deleteById(id);
    }else{
      throw new RuntimeException("Category not found");
    }
  }
}
