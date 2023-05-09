package com.example.lms;

import com.example.lms.models.Author;
import com.example.lms.models.Book;
import com.example.lms.models.Category;
import com.example.lms.models.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.lms.services.BookService;

@SpringBootApplication
public class LmsApplication implements CommandLineRunner {

  private final BookService bookService;

  @Autowired
  public LmsApplication(BookService bookService){
    this.bookService = bookService;
  }
  public static void main(String[] args) {
    SpringApplication.run(LmsApplication.class, args);
  }


  @Override
  public void run(String... args) throws Exception {
    addSampleData();
  }

  private void addSampleData() {
    Book book1 = new Book("ABC", "Book name", "My first book");
    Author author1 = new Author("Test name1", "Test description");
    Category category1 = new Category("Business books");
    Publisher publisher1 = new Publisher("First Publisher");
    book1.addAuthor(author1);
    book1.addCategory(category1);
    book1.addPublisher(publisher1);
    bookService.createBook(book1);

    Book book2 = new Book("ABCD", "Book name2", "My sec book");
    Author author2 = new Author("Test name2", "Test description2");
    Category category2 = new Category("Encyclpedia");
    Publisher publisher2 = new Publisher("Second Publisher");
    book2.addAuthor(author2);
    book2.addCategory(category2);
    book2.addPublisher(publisher2);
    bookService.createBook(book2);

    Book book3 = new Book("ABCDE", "Book name3", "My third book");
    Author author3 = new Author("Test name3", "Test description3");
    Category category3 = new Category("Children book");
    Publisher publisher3 = new Publisher("Third Publisher");
    book3.addAuthor(author3);
    book3.addCategory(category3);
    book3.addPublisher(publisher3);
    bookService.createBook(book3);
  }
}
