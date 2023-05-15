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
  public String deleteCategory(@PathVariable Long id, Model model){
    categoryService.deleteCategory(id);
    model.addAttribute("categories",categoryService.listAllCategories());
    return "categories";
  }
  @GetMapping("update-category/{id}")
  public String updateCategory(@PathVariable Long id, Model model){
    Category category = categoryService.findCategoryById(id);
    model.addAttribute("category",category);
    return "update-category";
  }
  @PostMapping("/save-update/{id}")
  public String updateCategory(@PathVariable Long id, Category category, BindingResult result, Model model){
    if(result.hasErrors()){
      return "update-category";
    }
    categoryService.updateCategory(category);
    model.addAttribute("categories", categoryService.listAllCategories());
    return "redirect:/categories";
  }
  @GetMapping("add-category")
  public String addCategory(Category category,Model model){
    model.addAttribute("category",category);
    return "add-category";
  }
  @PostMapping("/save-category")
  public String updateCategory(Category category, BindingResult result, Model model){
    if(result.hasErrors()){
      return "add-category";
    }
    categoryService.createCategory(category);
    model.addAttribute("categories", categoryService.listAllCategories());
    return "redirect:/categories";
  }
}
