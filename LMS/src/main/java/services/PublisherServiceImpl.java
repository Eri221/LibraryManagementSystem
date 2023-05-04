package services;

import java.util.List;
import java.util.Optional;
import models.Publisher;
import org.springframework.stereotype.Service;
import repositories.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService{
private final PublisherRepository publisherRepository;
public PublisherServiceImpl(PublisherRepository publisherRepository){
  this.publisherRepository = publisherRepository;
}

  @Override
  public List<Publisher> findAllPublishers() {
    return publisherRepository.findAll();
  }

  @Override
  public Publisher findPublisherById(Long id) {
    return publisherRepository.findById(id).orElseThrow(()->new RuntimeException("Publisher not found"));
  }

  @Override
  public void createPublisher(Publisher publisher) {
  publisherRepository.save(publisher);
  }

  @Override
  public void updatePublisher(Publisher publisher) {
  publisherRepository.save(publisher);
  }

  @Override
  public void deletePublisher(Long id) {
  Optional<Publisher> publisher = publisherRepository.findById(id);
  if(publisher.isPresent()){
    publisherRepository.deleteById(id);
  }else{
    throw new RuntimeException("Publisher not found");
  }
  }
}
