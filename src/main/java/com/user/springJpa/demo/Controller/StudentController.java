package com.user.springJpa.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.user.springJpa.demo.Entity.Student;
import com.user.springJpa.demo.Service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService Service;

	@GetMapping("/")
	public String Index() {
		return "Index";
	}

	@GetMapping("/register")
	public ModelAndView Register() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		return mv;
	}

	@GetMapping("/login")
	public String Login() {
		return "login";
	}

	@PostMapping("/submitted")
	public ResponseEntity<String> submitStudent(@ModelAttribute Student student) {
		Service.saveStudent(student);
		return ResponseEntity.ok("Student saved successfully");
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @ModelAttribute Student studentDetails) {
		Student updatedStudent = this.Service.updateStudent(id, studentDetails);
		if (updatedStudent != null) {
			return ResponseEntity.ok(updatedStudent);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<String> getStudentById(@PathVariable int id) {
		String student = this.Service.getStudentById(id);
		System.out.println(student);
		return ResponseEntity.ok(student);
	}

	@GetMapping("/update")
	public ModelAndView updateStudent() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("update");
		return mv;
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		String data = this.Service.deleteStudent(id);
		return ResponseEntity.ok(data);
	}

	@GetMapping("/getall")
	public List<Student> getAllStudents() {
		return this.Service.getAllStudents();
	}

}
