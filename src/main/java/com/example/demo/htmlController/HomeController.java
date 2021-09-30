package com.example.demo.htmlController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.moduls.Student;
import com.example.demo.services.StudentServices;

@Controller
public class HomeController {
	
	private StudentServices studentServices;
	@Autowired
	public HomeController(StudentServices studentServices) {
		this.studentServices = studentServices;
		
	}
	@GetMapping("/tableVeiw")
	public String homePage(Model model) {
		List<Student> students = studentServices.listStudents();
		System.out.println("Students : "+students);
		model.addAttribute("listStudents", students);
		return "index.html";
		
	}
	@RequestMapping("/new")
	public String showNewStudentPage(Model model) {
	    Student student = new Student();
	    model.addAttribute("student", student);
	     
	    return "registration.html";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentServices.save(student);
	     
	    return "redirect:/tableVeiw";
	    //return tableView page or home page
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_student.html");
	    Student student = studentServices.get(id);
	    mav.addObject("student", student);
	     
	    return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name = "id") int id) {
		studentServices.delete(id);
	    return "redirect:/tableVeiw";       
	}
	
	
	@RequestMapping("/registrationFrom")
	public String registrationFrom(Model model) {
	    Student student = new Student();
	    model.addAttribute("student", student);
	     
	    return "registrationFromUsingBootstrap.html";
	}
	@RequestMapping("/bootstrapTable")
	public String bootstrapTable(Model model) {
		List<Student> students = studentServices.listStudents();
		System.out.println("Students : "+students);
		model.addAttribute("listStudents", students);
	     
	    return "bootstrapTable.html";
	}

}