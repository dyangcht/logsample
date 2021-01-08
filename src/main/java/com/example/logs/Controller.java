package com.example.logs;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Service greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println("Testing: " + String.format(template, name));
		System.out.println("除錯內容: " + String.format(template, name));
		return new Service(counter.incrementAndGet(), String.format(template, name));
	}
}
