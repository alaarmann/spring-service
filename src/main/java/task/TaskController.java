package task;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class TaskController {

    @RequestMapping("/")
    @ResponseBody
    String task() {
        return "Here is the task service.";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TaskController.class, args);
    }
}
