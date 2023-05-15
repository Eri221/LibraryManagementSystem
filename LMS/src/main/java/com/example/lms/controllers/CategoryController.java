package com.example.lms.controllers;

import com.example.lms.models.Book;
import com.example.lms.models.Category;
import com.example.lms.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
  private final CategoryService categoryService;
  @Autowired
  public CategoryController(CategoryService categoryService){
    this.categoryService = categoryService;
  }

  @GetMapping("/categories")
  public String findAllCategories(Model model){
    model.addAttribute("categories", categoryService.listAllCategories());
    return "categories";
  }
  @GetMapping("remove-category/{id}")
  public String deleteBook(@PathVariable Long id, Model model){
    categoryService.deleteCategory(id);
    model.addAttribute("categories",categoryService.listAllCategories());
    return "categories";
  }
  @GetMapping("update-category/{id}")
  public String updateBook(@PathVariable Long id, Model model){
    Category category = categoryService.findCategoryById(id);
    model.addAttribute("category",category);
    return "update-category";
  }
  @PostMapping("/save-update/{id}")
  public String updateBook(@PathVariable Long id, Category category, BindingResult result, Model model){
    if(result.hasErrors()){
      return "update-category";
    }
    categoryService.updateCategory(category);
    model.addAttribute("categories", categoryService.listAllCategories());
    return "redirect:/categories";
  }
}
