package com.example.lms.controllers;

import com.example.lms.models.Book;
import com.example.lms.services.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping("/books")
  public String findAllBooks(Model model){
    List<Book> books = bookService.findAllBooks();
    model.addAttribute("books", books);
    return "books";
  }

  @GetMapping("/books/{id}")
  public String findBook(@PathVariable Long id, Model model){
    Book book = bookService.findBookById(id);
    model.addAttribute("book",book);
    return "details";
  }
}
