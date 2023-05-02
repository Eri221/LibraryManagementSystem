package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  @Column(length = 50, nullable = false, unique = true)
  String isbn;
  @Column(nullable = false, unique = true)
  String name;
  @Column(nullable = false)
  String description;


}
