// Importing required packages and classes
package net.javaguides.sms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.service.StudentService;

@Controller // Marks the class as a controller
public class StudentController {

	private StudentService studentService; // Declare a StudentService object

	public StudentController(StudentService studentService) { // Constructor to set the StudentService object
		super();
		this.studentService = studentService;
	}

	// Handler method to handle list students and return mode and view
	@GetMapping("/students") // Maps HTTP GET requests to "/students" URL path
	public String listStudents(Model model) { // Method to list students
		List<Student> students = studentService.getAllStudents(); // Get all students from the StudentService object
		model.addAttribute("students", students); // Add the students to the model
		model.addAttribute("student", new Student()); // Add a new empty student to the model
		return "students"; // Return the view name
	}

	@GetMapping("/students/new") // Maps HTTP GET requests to "/students/new" URL path
	public String createStudentForm(Model model) { // Method to create a student form
		Student student = new Student(); // Create a new empty student object
		model.addAttribute("student", student); // Add the student to the model
		return "create_student"; // Return the view name
	}

	@PostMapping("/students") // Maps HTTP POST requests to "/students" URL path
	public String saveStudent(@ModelAttribute("student") Student student) { // Method to save a student
		studentService.saveStudent(student); // Save the student using the StudentService object
		return "redirect:/students"; // Redirect to the "/students" URL path
	}

	@GetMapping("/students/edit/{id}") // Maps HTTP GET requests to "/students/edit/{id}" URL path
	public String editStudentForm(@PathVariable Long id, Model model) { // Method to edit a student form
		model.addAttribute("student", studentService.getStudentById(id)); // Add the student with the given id to the model
		return "edit_student"; // Return the view name
	}

	@PostMapping("/students/{id}") // Maps HTTP POST requests to "/students/{id}" URL path
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) { // Method to update a student
		Student existingStudent = studentService.getStudentById(id); // Get the student from the database by id
		existingStudent.setId(id); // Set the student id
		existingStudent.setFirstname(student.getFirstname()); // Set the student firstname
		existingStudent.setLastname(student.getLastname()); // Set the student lastname
		existingStudent.setEmail(student.getEmail()); // Set the student email
		studentService.updateStudent(existingStudent); // Save the updated student object
		return "redirect:/students"; // Redirect to the "/students" URL path
	}

	@GetMapping("/students/{id}") // Maps HTTP GET requests to "/students/{id}" URL path
	public String deleteStudent(@PathVariable Long id) { // Method to delete a student
		studentService.deleteStudentById(id); // Delete the student with the given id using the StudentService object
		return "redirect:/students"; // Redirect to the "/students" URL path
	}

}