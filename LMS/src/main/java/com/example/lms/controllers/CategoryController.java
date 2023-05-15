package com.example.lms.controllers;

import com.example.lms.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
}
