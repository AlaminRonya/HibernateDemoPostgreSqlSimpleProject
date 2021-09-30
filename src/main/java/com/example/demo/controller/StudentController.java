package com.example.demo.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.moduls.Student;
import com.example.demo.services.StudentServices;

@RestController
public class StudentController {
	private StudentServices studentServices;
	@Autowired
	public StudentController(StudentServices studentServices) {
		this.studentServices = studentServices;
	}
	@PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
		
        return studentServices.save(student);
    }
	
	@PostConstruct
	public void DaTaInsert() {
		Student student = new Student();
		student.setId(2);
		student.setName("Rony");
		student.setEmail("hprony12@gmail.com");
		student.setGender("Male");
		studentServices.save(student);
	
	}

}
