package models;

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
@Table(name = "authors")
public class Author {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Column(nullable = false, unique = true)
 private String name;
 @Column(nullable = false)
 private String description;
 @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
 private Set<Book> books = new HashSet<>();

  public Author(String name, String description) {
   this.name = name;
   this.description = description;
  }

  public Set<Book> getBooks() {
  return books;
 }
}
