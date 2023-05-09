package com.example.lms.services;

import java.util.List;
import com.example.lms.models.Author;
import org.springframework.stereotype.Service;
import com.example.lms.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{
private final AuthorRepository authorRepository;
public AuthorServiceImpl(AuthorRepository authorRepository){
  this.authorRepository = authorRepository;
}

  @Override
  public List<Author> findAllAuthors() {
    return authorRepository.findAll();
  }

  @Override
  public Author findAuthorById(Long id) {
    return authorRepository.findById(id).orElseThrow(()->new RuntimeException("Author not found"));
  }

  @Override
  public void createAuthor(Author author) {
    authorRepository.save(author);
  }

  @Override
  public void updateAuthor(Author author) {
    authorRepository.save(author);
  }

  @Override
  public void deleteAuthor(Long id) {
    Author author = authorRepository.findById(id).orElseThrow(()-> new RuntimeException("Author not found"));
    authorRepository.delete(author);
  }
}
