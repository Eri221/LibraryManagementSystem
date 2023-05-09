package com.example.lms.services;

import java.util.List;
import com.example.lms.models.Publisher;

public interface PublisherService {
List<Publisher> findAllPublishers();
Publisher findPublisherById(Long id);
void createPublisher(Publisher publisher);
void updatePublisher(Publisher publisher);
void deletePublisher(Long id);
}
