package com.example.lms.controllers;

import com.example.lms.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PublisherController {
private final PublisherService publisherService;
  @Autowired
  public PublisherController(PublisherService publisherService){
  this.publisherService = publisherService;
  }
  @GetMapping("/publishers")
  public String listAllPublishers(Model model){
    model.addAttribute("publishers", publisherService.findAllPublishers());
    return "publishers";
  }
  @GetMapping("remove-publisher/{id}")
  public String deletePublisher(@PathVariable Long id, Model model){
    publisherService.deletePublisher(id);
    model.addAttribute("publishers", publisherService.findAllPublishers());
    return "publishers";
  }
}
