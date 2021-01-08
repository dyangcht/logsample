package com.example.logs;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	private static final String template = "您好, %s!";
	private final AtomicLong counter = new AtomicLong();
	private final Logger logger = LoggerFactory.getLogger(Controller.class);

	@GetMapping("/greeting")
	public Service greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		logger.info("Testing: " + String.format(template, name));
		logger.info("除錯內容: " + String.format(template, name));
		return new Service(counter.incrementAndGet(), String.format(template, name));
	}
}
