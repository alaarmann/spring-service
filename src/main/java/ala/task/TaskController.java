package ala.task;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class TaskController {

  @Autowired
  private TaskRepository taskRepository;

  @GetMapping("/tasks")
  public Iterable<Task> findAll() {
	  return taskRepository.findAll();
  }
  
  @GetMapping("/tasks/{id}")
  public ResponseEntity<Task> findById(@PathVariable String id) {
	  Task task = taskRepository.findOne(Long.valueOf(id));
	  if (task == null) {
		  return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
	  }
	  return new ResponseEntity<Task>(task, HttpStatus.OK);
  }

  @PostMapping("/tasks")
  public ResponseEntity<Void> add(@RequestBody @Valid Task task, UriComponentsBuilder builder) {
	  if (task.getId() != 0) {
		  return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	  }
	  taskRepository.save(task);
	  HttpHeaders headers = new HttpHeaders();
      headers.setLocation(builder.path("/article/{id}").buildAndExpand(task.getId()).toUri());
	  return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }
  
  @DeleteMapping("/tasks/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable String id) {
	  taskRepository.delete(Long.valueOf(id));
	  return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/tasks/{id}")
  public ResponseEntity<Task> modifyById(@PathVariable String id, @RequestBody @Valid Task task) {
	  if (!taskRepository.exists(Long.valueOf(id))) {
		  return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
	  }
	  Task newTask = taskRepository.save(task);
	  return new ResponseEntity<Task>(newTask, HttpStatus.OK);
  }

}
