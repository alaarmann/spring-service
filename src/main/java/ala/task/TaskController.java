package ala.task;


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

  private final AtomicLong counter = new AtomicLong();
    @RequestMapping("/task")
    public Task task(@RequestParam(value="reference", defaultValue="DefaultReference") String reference) {
        return new Task(counter.incrementAndGet(), reference);
    }

}
