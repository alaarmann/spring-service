package ala.task;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  @Autowired
  private TaskRepository taskRepository;

  @RequestMapping("/tasks")
  public Iterable<Task> findAll() {
	  return taskRepository.findAll();
  }
  
  @GetMapping("/tasks/{reference}")
  public List<Task> findByReference(@PathVariable String reference) {
	  return taskRepository.findByReference(reference);
  }
  

}
