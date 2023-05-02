package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
 @Column(nullable = false, unique = true)
 String name;
 @Column(nullable = false)
 String description;

}
