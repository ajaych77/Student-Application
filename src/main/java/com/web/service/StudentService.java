package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.StudentRepository;
import com.web.model.Student;
@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {
		
		  Student stud = studentRepository.save(student);
		  
		  return stud;
		
	}

	public List<Student> displayStudents() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

}
