package com.example.lms.controllers;

import com.example.lms.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
