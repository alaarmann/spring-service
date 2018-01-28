package ala;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import ala.task.Task;
import ala.task.TaskRepository;

@SpringBootApplication
public class Application {
	@Bean
    public CommandLineRunner init(TaskRepository taskRepository, ApplicationContext ctx) {
        return args -> {

            System.out.println("Initialize repo:");
            taskRepository.save(new Task("Ref01"));
            taskRepository.save(new Task("Ref02"));
            taskRepository.save(new Task("Ref03"));
        	
            System.out.println("Inspecting beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}