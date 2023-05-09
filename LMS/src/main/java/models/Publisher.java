package models;

import java.util.Collection;
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
@Table(name = "publishers")
public class Publisher {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, unique = true)
  private String name;
  @ManyToMany(mappedBy = "publishers", cascade = CascadeType.ALL)
  private Set<Book> books = new HashSet<>();

  public Publisher(String name) {
    this.name = name;
  }

  public Set<Book> getBooks() {
    return books;
  }
}
