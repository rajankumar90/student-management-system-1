
/*List<Student> getAllStudents();: This method returns a list of all the students.
Student saveStudent(Student student);: This method saves the student object to the database and returns the saved student object.
Student getStudentById(Long id);: This method returns the student object for the given id.
Student updateStudent(Student student);: This method updates the student object and returns the updated student object.
void deleteStudentById(Long id);: This method deletes the student object for the given id.
*/
package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student  getStudentById(Long id);
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
}
