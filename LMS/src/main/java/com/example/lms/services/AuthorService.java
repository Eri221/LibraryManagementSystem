package com.example.lms.services;

import java.util.List;
import com.example.lms.models.Author;

public interface AuthorService {
List<Author> findAllAuthors();
Author findAuthorById(Long id);
void createAuthor(Author author);
void updateAuthor(Author author);
void deleteAuthor(Long id);
}
