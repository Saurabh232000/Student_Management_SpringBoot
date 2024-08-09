package com.user.springJpa.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.springJpa.demo.Entity.Student;
import com.user.springJpa.demo.Repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo student;

	public Student saveStudent(Student student) {
		return this.student.save(student);
	}

	public Student updateStudent(int id, Student studentDetails) {
		Optional<Student> stu = this.student.findById(id);

		return this.student.save(studentDetails);
	}

	public String getStudentById(int id) {

		Student byId = this.student.findById(id).get();
		return byId.getName() + byId.getEmail() + byId.getPassword() + byId.getCourse() + byId.getPhone();
	}

	public String deleteStudent(int id) {
		Student byId = this.student.findById(id).get();
		if (byId != null) {
			student.deleteById(byId.getId());
			return "Id Deleted Successfully";
		} else
			return "INVALID";
	}

	public List<Student> getAllStudents() {
		return this.student.findAll();
	}
}
