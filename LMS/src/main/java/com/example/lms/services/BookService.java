package com.example.lms.services;

import java.util.List;
import com.example.lms.models.Book;

public interface BookService {
  public List<Book> findAllBooks();
  public Book findBookById(Long id);
  public void createBook(Book book);
  public void deleteBook(Long id);
}
