package services;

import java.util.List;
import models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService{
  private BookRepository bookRepository;
  @Autowired
  public BookServiceImpl(BookRepository bookRepository){
    this.bookRepository=bookRepository;
  }

  @Override
  public List<Book> findAllBooks() {
    return bookRepository.findAll();
  }

  @Override
  public Book findBookById(Long id) {
    return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found"));
  }

  @Override
  public void createBook(Book book) {
    bookRepository.save(book);
  }

  @Override
  public void deleteBook(Long id) {
    Book book = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found"));
    bookRepository.deleteById(book.getId());
  }
}
