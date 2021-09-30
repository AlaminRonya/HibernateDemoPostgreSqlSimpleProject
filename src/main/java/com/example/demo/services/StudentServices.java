package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.moduls.Student;
import com.example.demo.repository.StudentRepository;

@Service 
public class StudentServices {
	private StudentRepository studentRepository;
	@Autowired
	public StudentServices(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	public Student save(Student student) {
		return studentRepository.save(student);
	}
	public List<Student> listStudents() {
		return studentRepository.findAll();
	}
	public Student get(int id) {
		return studentRepository.findById(id).get();
	}
	public void delete(int id) {
		studentRepository.deleteById(id);
    }

}
