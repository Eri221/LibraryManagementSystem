package com.example.lms.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false,unique = true)
  private String name;
  @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
  private Set<Book> books = new HashSet<>();

  public Category(String name) {
    this.name = name;
  }

  public Category() {

  }

  public Set<Book> getBooks() {
    return books;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }
}
