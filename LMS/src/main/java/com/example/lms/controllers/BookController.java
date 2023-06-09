package com.example.lms.controllers;

import com.example.lms.models.Book;
import com.example.lms.services.AuthorService;
import com.example.lms.services.BookService;
import com.example.lms.services.CategoryService;
import com.example.lms.services.PublisherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {


  private final BookService bookService;
  private final CategoryService categoryService;
  private final PublisherService publisherService;
  private final AuthorService authorService;
  @Autowired
  public BookController(BookService bookService, CategoryService categoryService, PublisherService publisherService, AuthorService authorService){
    this.authorService = authorService;
    this.categoryService = categoryService;
    this.publisherService =publisherService;
    this.bookService = bookService;
  }


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

  @GetMapping("remove-book/{id}")
  public String deleteBook(@PathVariable Long id, Model model){
    bookService.deleteBook(id);
    model.addAttribute("books",bookService.findAllBooks());
    return "books";
  }

  @GetMapping("update-book/{id}")
  public String updateBook(@PathVariable Long id, Model model){
    Book book = bookService.findBookById(id);
    model.addAttribute("book",book);
    model.addAttribute("categories",categoryService.listAllCategories());
    model.addAttribute("publishers", publisherService.findAllPublishers());
    model.addAttribute("authors",authorService.findAllAuthors());
    return "update-book";
  }
  @PostMapping("/save-update/{id}")
  public String updateBook(@PathVariable Long id, Book book, BindingResult result, Model model){
    if(result.hasErrors()){
      return "update-book";
    }
    bookService.updateBook(book);
    model.addAttribute("books", bookService.findAllBooks());
    return "redirect:/books";
  }
  @GetMapping("add-book")
  public String addBook(Book book,Model model){
    model.addAttribute("book",book);
    model.addAttribute("categories",categoryService.listAllCategories());
    model.addAttribute("publishers", publisherService.findAllPublishers());
    model.addAttribute("authors",authorService.findAllAuthors());
    return "add-book";
  }
  @PostMapping("/save-book")
  public String updateBook(Book book, BindingResult result, Model model){
    if(result.hasErrors()){
      return "add-book";
    }
    bookService.createBook(book);
    model.addAttribute("books", bookService.findAllBooks());
    return "redirect:/books";
  }
}
