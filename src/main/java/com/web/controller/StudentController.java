package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Student;
import com.web.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private final StudentService studentService;

	StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		
		return studentService.addStudent(student);
	}
	
	@GetMapping("/details")
	public List<Student> displayStudents(){
		return studentService.displayStudents();
	}

}
