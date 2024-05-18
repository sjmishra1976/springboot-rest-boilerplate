package com.training.rest.springws;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/student")
	public Student getStudent(@RequestParam(value = "id", defaultValue = "1") long id) {
		return new Student(id, "firstName","lastName",80);
	}
	
	@PostMapping("/student")
	public long createStudent(@RequestBody Student stud) {
		
		long id = counter.getAndIncrement();
		String fName= stud.firstName();
		String lName= stud.lastName();
		int grade= stud.grade();
		System.out.println("Student Added with Attributes:"+stud.toString());
		return id;
	}
}