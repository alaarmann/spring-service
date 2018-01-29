package ala.task;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import ala.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes=Application.class)
public class TaskControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testGetTasks() {
		@SuppressWarnings("unchecked")
		List<Object> apiResponse = restTemplate.getForObject("/tasks", List.class);
		assertEquals(apiResponse.size(), 3);
		@SuppressWarnings("unchecked")
		Map<String, Object> task = (Map<String, Object>) apiResponse.get(0);
		assertEquals("Ref01", task.get("reference"));
	}
}
