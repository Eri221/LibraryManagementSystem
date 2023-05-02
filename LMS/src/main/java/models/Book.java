package models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 50, nullable = false, unique = true)
  private String isbn;
  @Column(nullable = false, unique = true)
  private String name;
  @Column(nullable = false)
  private String description;
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "books_authors",
  joinColumns = {@JoinColumn(name = "book_id")},
  inverseJoinColumns = {@JoinColumn(name = "author_id")})
  private Set<Author> authors = new HashSet<>();
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "books_categories",
      joinColumns = {@JoinColumn(name = "book_id")},
      inverseJoinColumns = {@JoinColumn(name = "category_id")})
  private Set<Category> categories = new HashSet<>();
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "books_publishers",
      joinColumns = {@JoinColumn(name = "book_id")},
      inverseJoinColumns = {@JoinColumn(name = "publisher_id")})
  private Set<Publisher> publishers = new HashSet<>();

}
